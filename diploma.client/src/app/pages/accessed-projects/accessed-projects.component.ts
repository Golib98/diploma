import {Component, OnInit} from '@angular/core';
import {MenuItem} from "../../../model/MenuItem";
import {MenuListService} from "../../services/menu-list.service";
import {AccessedProjectsService} from "./accessed-projects.service";
import {AllProjectCard} from "../../../model/AllProjectCard";
import {MatDialog, MatDialogConfig} from "@angular/material";
import {AccessedProjectDetailsComponent} from "./components/accessed-project-details/accessed-project-details.component";

@Component({
  selector: 'app-accessed-projects',
  templateUrl: './accessed-projects.component.html',
  styleUrls: ['./accessed-projects.component.scss']
})
export class AccessedProjectsComponent implements OnInit {

  menuItems: MenuItem[];
  projects: AllProjectCard[];

  constructor(private menuListService: MenuListService,
              private accessedProjectsService: AccessedProjectsService,
              private matDialog: MatDialog,
  ) {
  }

  ngOnInit() {
    this.menuListService.menuList.then(value => this.menuItems = value);
    this.accessedProjectsService.accessedProjects.then(value => this.projects = value);
  }

  openProjectDialog(projectId: string) {
    this.matDialog.open(AccessedProjectDetailsComponent, {
      data: projectId,
      width: '70%',
      height: '70%'
    } as MatDialogConfig)
  }
}
