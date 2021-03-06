import {Component, OnInit} from '@angular/core';
import {MenuItem} from "../../../model/MenuItem";
import {MenuListService} from "../../services/menu-list.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  menuItems: MenuItem[];

  constructor(private menuListService: MenuListService) {
  }

  ngOnInit(): void {
    this.menuListService.menuList.then(value => this.menuItems = value);
  }
}
