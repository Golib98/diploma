import {Component, OnInit} from '@angular/core';
import {MenuItem} from "../../../model/MenuItem";
import {MenuListService} from "../../services/menu-list.service";
import {MyProjectDetail} from "../../../model/MyProjectDetail";
import {UserProfileService} from "./user-profile.service";
import {LoginService} from "../../common/login/login.service";
import {ProfessorInfo} from "../../../model/ProfessorInfo";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {

  menuItems: MenuItem[];
  loading: boolean = false;
  professorInfo: ProfessorInfo = new ProfessorInfo();

  constructor(
    private menuListService: MenuListService,
    private userProfileService: UserProfileService,
    private loginService: LoginService,
  ) {
  }

  ngOnInit() {
    this.menuListService.menuList.then(value => this.menuItems = value);
    this.userProfileService.professorInfo.then(value => {
      this.professorInfo = value;
    })
  }

  addProject(myProject: MyProjectDetail) {
    this.loading = true;
    this.userProfileService.addProject(myProject).then(ignore => {
      this.loading = false;
    });
  }
}
