import {Component, OnInit} from '@angular/core';
import {AllProjectCard} from "../../../model/AllProjectCard";
import {AllProjectsService} from "./all-projects.service";
import {MenuListService} from "../../services/menu-list.service";
import {MenuItem} from "../../../model/MenuItem";
import {AllProjectFilter} from "../../../model/gen/AllProjectFilter";
import {ProfessorDict} from "../../../model/gen/ProfessorDict";
import {spheres} from "../my-projects/components/my-project-edit-dialog/my-project-edit-dialog.component";

@Component({
  selector: 'app-all-projects',
  templateUrl: './all-projects.component.html',
  styleUrls: ['./all-projects.component.scss']
})
export class AllProjectsComponent implements OnInit {
  myProjects: AllProjectCard[];
  unfilteredProjects: AllProjectCard[];
  menuItems: MenuItem[];
  findText: string = '';
  professorsDict: ProfessorDict[];
  isChosen = false;

  spheres = spheres;

  constructor(
    private allProjectsService: AllProjectsService,
    private menuListService: MenuListService,
  ) {
  }

  async ngOnInit() {
    this.allProjectsService.allProjects(null).then(value => {
      this.myProjects = value;
      this.unfilteredProjects = value;
    });
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

  filter() {
    this.myProjects = this.unfilteredProjects.filter(value => {
      return value.title.toLowerCase().includes(this.findText.toLowerCase());
    })
  }

  find(filter: AllProjectFilter) {

    this.allProjectsService.allProjects(filter).then(value => {
      this.myProjects = value;
      this.unfilteredProjects = value;
    });

  }

  respondToProject(projectId: AllProjectCard) {
    this.allProjectsService.respond(projectId.id).then(value => {
      projectId.isResponded = true;
    })
  }
}
