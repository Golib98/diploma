import {Component, OnInit} from '@angular/core';
import {MenuListService} from "../../services/menu-list.service";
import {MenuItem} from "../../../model/MenuItem";
import {MyProject} from "../../../model/MyProject";
import {MyProjectsService} from "./my-projects.service";

@Component({
  selector: 'app-my-projects',
  templateUrl: './my-projects.component.html',
  styleUrls: ['./my-projects.component.scss']
})
export class MyProjectsComponent implements OnInit {

  menuItems: MenuItem[];
  myProjects: MyProject[];

  constructor(
    private menuListService: MenuListService,
    private myProjectsService: MyProjectsService
  ) {
  }

  ngOnInit() {
    this.menuListService.menuList.then(value => this.menuItems = value);

    this.myProjectsService.myProjects.then(value => this.myProjects = value);
  }

}
