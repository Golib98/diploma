import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {UniversityCardInfo} from "../../../../../model/UniversityCardInfo";

@Component({
  selector: 'app-university-card',
  templateUrl: './university-card.component.html',
  styleUrls: ['./university-card.component.scss']
})
export class UniversityCardComponent implements OnInit {

  @Input() model: UniversityCardInfo;
  @Output() likeButtonEmitter: EventEmitter<VoidFunction>;
  @Output() compareButtonEmitter: EventEmitter<VoidFunction>;

  constructor() {
  }

  ngOnInit() {
  }

}
