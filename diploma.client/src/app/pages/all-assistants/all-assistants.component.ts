import {Component, OnInit} from '@angular/core';
import {MenuListService} from "../../services/menu-list.service";
import {MenuItem} from "../../../model/MenuItem";
import {AllAssistantsService} from "./all-assistants.service";
import {AllAssistantCard} from "../../../model/AllAssistantCard";
import {AllAssistantsIn} from "../../../model/AllAssistantsIn";

@Component({
  selector: 'app-all-assistants',
  templateUrl: './all-assistants.component.html',
  styleUrls: ['./all-assistants.component.scss']
})
export class AllAssistantsComponent implements OnInit {

  menuItems: MenuItem[];
  assistantCards: AllAssistantCard[];

  constructor(
    private menuListService: MenuListService,
    private allAssistantsService: AllAssistantsService
  ) {
  }

  ngOnInit() {
    this.menuListService.menuList.then(value => this.menuItems = value);
    this.allAssistantsService.getAssistantCards(null).then(value => this.assistantCards = value);
  }

  findAssistants(allAssistantsIn: AllAssistantsIn) {
    console.log(`emitted ${JSON.stringify(allAssistantsIn)}`);
    this.allAssistantsService.getAssistantCards(allAssistantsIn).then(value => this.assistantCards = value);
  }
}
