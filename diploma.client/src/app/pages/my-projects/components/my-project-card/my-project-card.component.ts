import {Component, Input} from '@angular/core';
import {MyProject} from "../../../../../model/MyProject";

@Component({
  selector: 'app-my-project-card',
  templateUrl: './my-project-card.component.html',
  styleUrls: ['./my-project-card.component.scss']
})
export class MyProjectCardComponent {

  @Input() myProject: MyProject;

  constructor() {
  }

}
