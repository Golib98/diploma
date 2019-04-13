import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {MyAssistantCard} from "../../../../../model/MyAssistantCard";

@Component({
  selector: 'app-responds',
  templateUrl: './responds.component.html',
  styleUrls: ['./responds.component.scss']
})
export class RespondsComponent implements OnInit {

  @Input() myAssistant: MyAssistantCard;
  @Output() acceptButtonEmitter: EventEmitter<void> = new EventEmitter();
  @Output() rejectButtonEmitter: EventEmitter<void> = new EventEmitter();

  constructor() {
  }

  ngOnInit() {
  }

}
