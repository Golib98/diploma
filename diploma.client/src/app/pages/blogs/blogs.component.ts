import {Component, OnInit} from '@angular/core';
import {MenuItem} from "../../../model/MenuItem";
import {MenuListService} from "../../services/menu-list.service";
import {HttpService} from "../../services/http.service";
import {map} from "rxjs/operators";
import {Blog} from "../../../model/Blog";

@Component({
  selector: 'app-blogs',
  templateUrl: './blogs.component.html',
  styleUrls: ['./blogs.component.scss']
})
export class BlogsComponent implements OnInit {


  mi !: MenuItem[];

  blogs: Blog[] = [];
  showBig = false;

  current: Blog = new Blog();

  constructor(
    private menuListService: MenuListService,
    private http: HttpService) {
  }

  ngOnInit() {
    this.menuListService.menuList.then(value => this.mi = value);

    this.http.get('/blog/all')
      .pipe(map<any, Blog[]>(k => k.body))
      .toPromise()
      .then(value => {
        console.log(value);
        value.forEach(value1 => {
          const blog = new Blog();
          Object.assign(blog, value1);
          this.blogs.push(blog)
        });
      });
  }
}
