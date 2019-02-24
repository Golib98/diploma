import {Component, OnInit} from '@angular/core';
import {MenuItem} from "../../../model/MenuItem";
import {MenuListService} from "../../services/menu-list.service";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {

  menuItems: MenuItem[];

  constructor(private menuListService: MenuListService) {
  }

  ngOnInit() {
    this.menuListService.menuList.then(value => this.menuItems = value);
  }

}
