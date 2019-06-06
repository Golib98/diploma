import {Component, OnInit} from '@angular/core';
import {MenuItem} from "../../../model/MenuItem";
import {MenuListService} from "../../services/menu-list.service";
import {Blog} from "../../../model/Blog";
import {FileWrapper} from "../../../model/gen/FileWrapper";
import {map} from "rxjs/operators";
import {HttpService} from "../../services/http.service";
import {PopupComponent} from "../../common/popup/popup.component";
import {MatDialog} from "@angular/material";

@Component({
  selector: 'app-blogs-article',
  templateUrl: './blogs-article.component.html',
  styleUrls: ['./blogs-article.component.scss']
})
export class BlogsArticleComponent implements OnInit {

  menuItems: MenuItem[];

  blogToSave: Blog = new Blog();

  constructor(private menuListService: MenuListService,
              private http: HttpService,
              private dialog: MatDialog) {
  }

  ngOnInit() {
    this.menuListService.menuList.then(value => this.menuItems = value);
  }

  handleFile(files: FileList) {
    console.log({files});
    this.blogToSave.files = files;
  }

  saveBlog() {

    this.uploadFile()
      .then(k => {

        console.log(k);

        if (k && k[0]) {
          console.log('kjnadslf87');
          this.blogToSave.imageId = k[0].id;
        }

        this.blogToSave.files = undefined;
        this.http.post("/blog/save", {blog: JSON.stringify(this.blogToSave)})
          .pipe(map<any, void>(l => l))
          .toPromise()
          .then(value => {
            this.blogToSave = new Blog();
            this.dialog.open(PopupComponent, {
              width: '250px',
              data: 'Blog added'
            });
          });
      })


  }


  uploadFile(): Promise<FileWrapper[]> {
    if (!this.blogToSave.files) return Promise.resolve(null);

    let ret: Promise<FileWrapper>[] = [];

    for (let i = 0; i < this.blogToSave.files.length; i++) {
      ret.push(
        this.http.postFile('/files/save', this.blogToSave.files[i])
          .pipe(map<any, FileWrapper>(k => k.body))
          .toPromise()
      );
    }

    return Promise.all(ret)

  }
}
