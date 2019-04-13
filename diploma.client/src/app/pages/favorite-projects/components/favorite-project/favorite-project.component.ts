import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AllProjectCard} from "../../../../../model/AllProjectCard";

@Component({
  selector: 'app-favorite-project',
  templateUrl: './favorite-project.component.html',
  styleUrls: ['./favorite-project.component.scss']
})
export class FavoriteProjectComponent implements OnInit {

  @Input() myProject: AllProjectCard;
  @Output() removeButtonEmitter: EventEmitter<string> = new EventEmitter();

  constructor() {
  }

  ngOnInit() {
  }

}
