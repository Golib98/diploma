import {Component, OnInit} from '@angular/core';
import {MenuItem} from "../../../model/MenuItem";
import {UniversityCardInfo} from "../../../model/UniversityCardInfo";
import {MenuListService} from "../../services/menu-list.service";
import {UniversitiesService} from "./universities.service";

@Component({
  selector: 'app-universities',
  templateUrl: './universities.component.html',
  styleUrls: ['./universities.component.scss']
})
export class UniversitiesComponent implements OnInit {

  menuItems: MenuItem[];
  universityCards: UniversityCardInfo[] = [];

  constructor(
    private menuListService: MenuListService,
    private universitiesService: UniversitiesService) {
  }

  ngOnInit() {
    this.menuListService.menuList.then(value => this.menuItems = value);
    this.universitiesService.universities.then(value => this.universityCards = value);
  }

}
