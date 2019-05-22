import {Component, OnInit} from '@angular/core';
import {MenuListService} from "../../services/menu-list.service";
import {MenuItem} from "../../../model/MenuItem";

@Component({
  selector: 'app-jobs',
  templateUrl: './jobs.component.html',
  styleUrls: ['./jobs.component.scss']
})
export class JobsComponent implements OnInit {

  mi !: MenuItem[];

  constructor(private menuListService: MenuListService) {
  }

  ngOnInit() {
    this.menuListService.menuList.then(value => this.mi = value);
  }

}
