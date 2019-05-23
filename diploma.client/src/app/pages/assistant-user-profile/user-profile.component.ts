import {Component, OnInit} from '@angular/core';
import {MenuItem} from "../../../model/MenuItem";
import {MenuListService} from "../../services/menu-list.service";
import {UserProfileService} from "./user-profile.service";
import {StudentInfo} from "../../../model/StudentInfo";
import {ProfessorInfo} from "../../../model/ProfessorInfo";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {

  professorInfo: ProfessorInfo = new ProfessorInfo();

  menuItems: MenuItem[];
  loading: boolean = false;
  studentInfo = new StudentInfo();

  constructor(
    private menuListService: MenuListService,
    private userProfileService: UserProfileService,
  ) {
  }

  ngOnInit() {
    this.menuListService.menuList.then(value => this.menuItems = value);
    this.userProfileService.professorInfo.then(value => {
      this.professorInfo = value;
    })
  }
}
