import {Component, EventEmitter, Input, Output} from '@angular/core';
import {MyProjectCard} from "../../../../../model/MyProjectCard";

@Component({
  selector: 'app-my-project-card',
  templateUrl: './my-project-card.component.html',
  styleUrls: ['./my-project-card.component.scss']
})
export class MyProjectCardComponent {

  @Input() myProject: MyProjectCard;
  @Output() editButtonEmitter = new EventEmitter<void>();
  @Output() deleteButtonEmitter = new EventEmitter<void>();

  constructor() {
  }
}
