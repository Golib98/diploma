import {Component, OnInit} from '@angular/core';
import {MenuItem} from "../../../model/MenuItem";
import {MenuListService} from "../../services/menu-list.service";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {
  menuList: MenuItem[];

  constructor(private menuListService: MenuListService) {
  }

  ngOnInit() {
    this.menuListService.menuList.then(value => this.menuList = value);
  }

}
