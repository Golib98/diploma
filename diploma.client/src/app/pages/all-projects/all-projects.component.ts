import {Component, OnInit} from '@angular/core';
import {AllProjectCard} from "../../../model/AllProjectCard";
import {AllProjectsService} from "./all-projects.service";
import {MenuListService} from "../../services/menu-list.service";
import {MenuItem} from "../../../model/MenuItem";

@Component({
  selector: 'app-all-projects',
  templateUrl: './all-projects.component.html',
  styleUrls: ['./all-projects.component.scss']
})
export class AllProjectsComponent implements OnInit {
  myProjects: AllProjectCard[];
  menuItems: MenuItem[];


  constructor(
    private allProjectsService: AllProjectsService,
    private menuListService: MenuListService,
  ) {
  }

  ngOnInit() {
    this.allProjectsService.allProjects.then(value => this.myProjects = value);
    this.menuListService.menuList.then(value => this.menuItems = value);
  }

  likeProject(id: string) {
    this.allProjectsService.likeProject(id).then(ignore => {
      let allProjectCard = this.myProjects.find(value => value.id === id);
      allProjectCard.isLiked = true;
    })
  }

  dislikeProject(id: string) {
    this.allProjectsService.dislikeProject(id).then(ignore => {
      let allProjectCard = this.myProjects.find(value => value.id === id);
      allProjectCard.isLiked = false;
    })
  }
}
