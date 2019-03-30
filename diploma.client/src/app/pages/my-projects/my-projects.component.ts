import {Component, OnInit} from '@angular/core';
import {MenuListService} from "../../services/menu-list.service";
import {MenuItem} from "../../../model/MenuItem";
import {MyProjectCard} from "../../../model/MyProjectCard";
import {MyProjectsService} from "./my-projects.service";

@Component({
  selector: 'app-my-projects',
  templateUrl: './my-projects.component.html',
  styleUrls: ['./my-projects.component.scss']
})
export class MyProjectsComponent implements OnInit {

  menuItems: MenuItem[];
  myProjects: MyProjectCard[];

  constructor(
    private menuListService: MenuListService,
    private myProjectsService: MyProjectsService,
  ) {
  }

  ngOnInit() {
    this.menuListService.menuList.then(value => this.menuItems = value);
    this.myProjectsService.myProjects.then(value => this.myProjects = value);
  }

  editMyProject(title: string) {

    let myProject = this.myProjects.find(value => value.title === title);
    myProject.isButtonsDisabled = true;

    setTimeout(() => {
      myProject.isButtonsDisabled = false;
    }, 2000)

  }

  deleteMyProject(title: string) {

    let myProject = this.myProjects.find(value => value.title === title);
    myProject.isButtonsDisabled = true;

    this.myProjectsService.deleteMyProject(myProject.id)
      .then(() => {
        this.myProjects = this.myProjects.filter(value => value.title !== title);
      });

  }
}
