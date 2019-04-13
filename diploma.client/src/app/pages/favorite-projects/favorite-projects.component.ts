import {Component, OnInit} from '@angular/core';
import {MenuListService} from "../../services/menu-list.service";
import {MenuItem} from "../../../model/MenuItem";
import {AllProjectCard} from "../../../model/AllProjectCard";
import {FavoriteProjectsService} from "./favorite-projects.service";
import {AllProjectsService} from "../all-projects/all-projects.service";

@Component({
  selector: 'app-favorite-projects',
  templateUrl: './favorite-projects.component.html',
  styleUrls: ['./favorite-projects.component.scss']
})
export class FavoriteProjectsComponent implements OnInit {

  menuItems: MenuItem[];
  projects: AllProjectCard[];

  constructor(
    private menuListService: MenuListService,
    private favoriteProjectsService: FavoriteProjectsService,
    private allProjectsService: AllProjectsService
  ) {
  }

  ngOnInit() {
    this.menuListService.menuList.then(value => this.menuItems = value);
    this.favoriteProjectsService.favoriteProjects.then(value => this.projects = value);
  }

  removeProject(projectId: string) {
    console.log('projectId', projectId);
    this.allProjectsService.dislikeProject(projectId).then(value => {
      this.projects = this.projects.filter(value1 => value1.id !== projectId);
    });
  }
}
