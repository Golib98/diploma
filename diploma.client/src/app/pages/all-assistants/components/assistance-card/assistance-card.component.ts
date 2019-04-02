import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AllAssistantCard} from "../../../../../model/AllAssistantCard";
import {assertDataInRange} from "@angular/core/src/render3/assert";

@Component({
  selector: 'app-assistance-card',
  templateUrl: './assistance-card.component.html',
  styleUrls: ['./assistance-card.component.scss']
})
export class AssistanceCardComponent implements OnInit {

  @Input() assistant: AllAssistantCard;
  @Output() goToChatButtonEmitter: EventEmitter<void>;

  constructor() {
  }

  ngOnInit() {

  }

}
