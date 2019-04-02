import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {AllAssistantsIn} from "../../../../../model/AllAssistantsIn";

@Component({
  selector: 'app-assistants-filter',
  templateUrl: './assistants-filter.component.html',
  styleUrls: ['./assistants-filter.component.scss']
})
export class AssistantsFilterComponent implements OnInit {

  firstName: string = "";
  lastName: string = "";
  birthDate: Date = null;

  @Output() findButtonEmitter: EventEmitter<AllAssistantsIn> = new EventEmitter<AllAssistantsIn>();

  constructor() {
  }

  ngOnInit() {
  }

  findAssistants() {
  }

  find() {
    this.findButtonEmitter.emit(new AllAssistantsIn(this.firstName, this.lastName, this.birthDate));
  }
}
