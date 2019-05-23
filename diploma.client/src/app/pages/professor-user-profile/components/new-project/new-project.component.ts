import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {MyProjectDetail} from "../../../../../model/MyProjectDetail";
import {spheres} from "../../../my-projects/components/my-project-edit-dialog/my-project-edit-dialog.component";

@Component({
  selector: 'app-new-project',
  templateUrl: './new-project.component.html',
  styleUrls: ['./new-project.component.scss']
})
export class NewProjectComponent implements OnInit {

  myProject = new MyProjectDetail();

  spheres: string[] = spheres;

  @Output() addButtonEventEmitter = new EventEmitter<MyProjectDetail>();

  constructor() {
  }

  ngOnInit() {
    this.myProject.isOpened = true;
  }

  saveProject() {
    this.addButtonEventEmitter.emit(this.myProject);
    this.myProject = new MyProjectDetail();
    this.myProject.isOpened = true;
  }

  handleFile(fileList: FileList) {
    this.myProject.files = fileList;
  }
}
