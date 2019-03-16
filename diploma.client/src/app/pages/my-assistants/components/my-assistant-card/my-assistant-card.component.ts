import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {MyAssistantCard} from "../../../../../model/MyAssistantCard";

@Component({
  selector: 'app-my-assistant-card',
  templateUrl: './my-assistant-card.component.html',
  styleUrls: ['./my-assistant-card.component.scss']
})
export class MyAssistantCardComponent implements OnInit {

  @Input() myAssistant: MyAssistantCard;
  @Output() sendMailButtonEmitter = new EventEmitter<void>();
  @Output() refusingButtonEmitter = new EventEmitter<void>();

  constructor() {
  }

  ngOnInit() {
  }

}
