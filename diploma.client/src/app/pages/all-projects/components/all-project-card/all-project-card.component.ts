import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AllProjectCard} from "../../../../../model/AllProjectCard";

@Component({
  selector: 'app-all-project-card',
  templateUrl: './all-project-card.component.html',
  styleUrls: ['./all-project-card.component.scss']
})
export class AllProjectCardComponent implements OnInit {

  @Input() myProject: AllProjectCard;
  @Output() toListButtonEmitter = new EventEmitter<void>();
  @Output() removeFromListButtonEmitter = new EventEmitter<void>();
  @Output() toRespondButtonEmitter = new EventEmitter<string>();

  constructor() {
  }

  ngOnInit() {
  }

  markProject(isLiked: boolean) {
    if (isLiked) this.removeFromListButtonEmitter.emit();
    else this.toListButtonEmitter.emit();
  }
}
