import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AllProjectCard} from "../../../../../model/AllProjectCard";

@Component({
  selector: 'app-accessed-project',
  templateUrl: './accessed-project.component.html',
  styleUrls: ['./accessed-project.component.scss']
})
export class AccessedProjectComponent implements OnInit {

  @Input() myProject: AllProjectCard;
  @Output() openButtonEmitter: EventEmitter<string> = new EventEmitter();

  constructor() {
  }

  ngOnInit() {
  }

}
