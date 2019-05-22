import {Component, OnInit} from '@angular/core';
import {MenuItem} from "../../../model/MenuItem";
import {MenuListService} from "../../services/menu-list.service";

@Component({
  selector: 'app-blogs',
  templateUrl: './blogs.component.html',
  styleUrls: ['./blogs.component.scss']
})
export class BlogsComponent implements OnInit {


  mi !: MenuItem[];

  constructor(private menuListService: MenuListService) {
  }

  ngOnInit() {
    this.menuListService.menuList.then(value => this.mi = value);
  }
}
