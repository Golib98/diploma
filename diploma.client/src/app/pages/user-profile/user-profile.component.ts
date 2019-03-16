import {Component, OnInit} from '@angular/core';
import {MenuItem} from "../../../model/MenuItem";
import {MenuListService} from "../../services/menu-list.service";
import {MyProjectDetail} from "../../../model/MyProjectDetail";
import {UserProfileService} from "./user-profile.service";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {

  menuItems: MenuItem[];
  loading = false;

  constructor(
    private menuListService: MenuListService,
    private userProfileService: UserProfileService
  ) {
  }

  ngOnInit() {
    this.menuListService.menuList.then(value => this.menuItems = value);
  }

  addProject(myProject: MyProjectDetail) {
    this.loading = true;
    this.userProfileService.addProject(myProject).then(ignore => {
      this.loading = false;
    });
  }
}
