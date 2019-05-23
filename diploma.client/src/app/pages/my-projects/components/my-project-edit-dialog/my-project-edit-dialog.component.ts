import {Component, Inject} from '@angular/core';
import {MyProjectDetail} from "../../../../../model/MyProjectDetail";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {FormControl} from "@angular/forms";

@Component({
  selector: 'app-my-project-edit-dialog',
  templateUrl: './my-project-edit-dialog.component.html',
  styleUrls: ['./my-project-edit-dialog.component.scss']
})
export class MyProjectEditDialogComponent {

  myProject = new MyProjectDetail();
  deadline: FormControl;

  constructor(public ref: MatDialogRef<MyProjectEditDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: MyProjectDetail) {
    this.myProject = data;
  }

  spheres = spheres;


}

export const spheres: string[] = [
  'Engineering & Technology',
  'Social Sciences',
  'Natural Sciences & Mathematics',
  'Medicine & Health',
  'Agriculture & Forestry',
  'Education & Training',
  'Computer Science & IT',
  'Applied Sciences & Professions',
  'Arts, Design & Architecture',
  'Business & Management',
  'Environmental Studies & Earth Sciences',
  'Hospitality, Leisure & Sports',
  'Humanities',
  'Journalism & Media',
  'Law',
  'Medicine & Health',
];

