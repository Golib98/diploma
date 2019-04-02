import {Component, EventEmitter, Inject} from '@angular/core';
import {MyProjectDetail} from "../../../../../model/MyProjectDetail";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";

@Component({
  selector: 'app-my-project-edit-dialog',
  templateUrl: './my-project-edit-dialog.component.html',
  styleUrls: ['./my-project-edit-dialog.component.scss']
})
export class MyProjectEditDialogComponent {

  myProject = new MyProjectDetail();

  constructor(public myProjectEditDialogComponentMatDialogRef: MatDialogRef<MyProjectEditDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: MyProjectDetail) {
    this.myProject = data;
  }

}
