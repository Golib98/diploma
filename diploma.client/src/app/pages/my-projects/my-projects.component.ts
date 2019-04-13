import {Component, OnInit} from '@angular/core';
import {MenuListService} from "../../services/menu-list.service";
import {MenuItem} from "../../../model/MenuItem";
import {MyProjectCard} from "../../../model/MyProjectCard";
import {MyProjectsService} from "./my-projects.service";
import {MatDialog} from "@angular/material";
import {MyProjectEditDialogComponent} from "./components/my-project-edit-dialog/my-project-edit-dialog.component";
import {PopupAskComponent} from "../../common/popup-ask/popup-ask.component";

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
    private matDialog: MatDialog,
  ) {
  }

  ngOnInit() {
    this.menuListService.menuList.then(value => this.menuItems = value);
    this.myProjectsService.myProjects.then(value => {
      console.log(value);
      this.myProjects = value
    });
  }

  editMyProject(id: string) {


    let myProject = this.myProjects.find(value => value.id === id);
    myProject.isButtonsDisabled = true;

    const matDialogRef = this.matDialog.open(MyProjectEditDialogComponent, {data: myProject});
    matDialogRef.afterClosed().subscribe(value => {
      myProject.isButtonsDisabled = false;
      this.myProjectsService.updateProject(value);
    })


  }

  deleteMyProject(id: string) {

    let myProject = this.myProjects.find(value => value.id === id);
    myProject.isButtonsDisabled = true;

    const matDialogRef = this.matDialog.open(PopupAskComponent, {data: 'Are you sure?'});
    matDialogRef.afterClosed().subscribe(value => {
      myProject.isButtonsDisabled = false;
      if (!value) return;
      this.myProjectsService.deleteMyProject(myProject.id)
        .then(() => {
          this.myProjects = this.myProjects.filter(value => value.id !== id);
        });
    });

  }
}
