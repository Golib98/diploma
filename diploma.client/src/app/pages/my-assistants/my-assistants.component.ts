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
  myResponds: MyAssistantCard[];

  constructor(
    private menuListService: MenuListService,
    private myAssistantsService: MyAssistantsService,
  ) {
  }

  ngOnInit() {
    this.menuListService.menuList.then(value => this.menuItems = value);
    this.myAssistantsService.myAssistants.then(value => this.myAssistants = value);
    this.myAssistantsService.myResponds.then(value => {
      this.myResponds = value;
      console.log(value);
    });
  }

  acceptProject(assistantId: string, projectTitle: string) {
    this.myAssistantsService.acceptProject(assistantId, projectTitle)
      .then(ignore => {

        this.myAssistants.push(this.myResponds.find(value => {
          return value.id === assistantId && value.projectTitle === projectTitle
        }));

        this.myResponds = this.myResponds
          .filter(value1 => {
            return !(value1.id === assistantId && value1.projectTitle === projectTitle);
          })

      });
  }

  rejectProject(assistantId: string, projectTitle: string) {
    this.myAssistantsService.rejectProject(assistantId, projectTitle)
      .then(value => {
        this.myResponds = this.myResponds
          .filter(value1 => {
            return !(value1.id === assistantId && value1.projectTitle === projectTitle);
          })
      })
  }
}
