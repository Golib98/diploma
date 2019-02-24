import {Component, OnInit} from '@angular/core';
import {MenuItem} from "../../../model/MenuItem";
import {UniversityCardInfo} from "../../../model/UniversityCardInfo";
import {MenuListService} from "../../services/menu-list.service";

@Component({
  selector: 'app-universities',
  templateUrl: './universities.component.html',
  styleUrls: ['./universities.component.scss']
})
export class UniversitiesComponent implements OnInit {

  menuItems: MenuItem[];
  universityCards: UniversityCardInfo[] = [];

  constructor(private menuListService: MenuListService) {
  }

  ngOnInit() {
    this.menuListService.menuList.then(value => this.menuItems = value);

    let i: number = 0;
    while (i < 10) {
      i++;
      let model = {
        label: 'IITU' + i,
        text: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
        mainImageUrl: 'https://material.angular.io/assets/img/examples/shiba2.jpg',
        logoUrl: null
      } as UniversityCardInfo;

      this.universityCards.push(model)
    }
  }

}
