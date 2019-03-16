import {Component, OnInit} from '@angular/core';
import {MenuItem} from "../../../model/MenuItem";
import {MenuListService} from "../../services/menu-list.service";
import {MyAssistantsService} from "./my-assistants.service";
import {MyAssistantCard} from "../../../model/MyAssistantCard";

@Component({
  selector: 'app-my-assistants',
  templateUrl: './my-assistants.component.html',
  styleUrls: ['./my-assistants.component.scss']
})
export class MyAssistantsComponent implements OnInit {

  menuItems: MenuItem[];
  myAssistants: MyAssistantCard[];

  constructor(
    private menuListService: MenuListService,
    private myAssistantsService: MyAssistantsService,
  ) {
  }

  ngOnInit() {
    this.menuListService.menuList.then(value => this.menuItems = value);
    this.myAssistantsService.myAssistants.then(value => this.myAssistants = value);
  }

}
