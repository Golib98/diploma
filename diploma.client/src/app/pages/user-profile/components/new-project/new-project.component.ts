import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {MyProjectDetail} from "../../../../../model/MyProjectDetail";

@Component({
  selector: 'app-new-project',
  templateUrl: './new-project.component.html',
  styleUrls: ['./new-project.component.scss']
})
export class NewProjectComponent implements OnInit {

  myProject = new MyProjectDetail();

  @Output() addButtonEventEmitter = new EventEmitter<MyProjectDetail>();

  constructor() {
  }

  ngOnInit() {
    this.myProject.isOpened = true;
    // this.myProject.description = '';
    // this.myProject.title = '';
  }

}
