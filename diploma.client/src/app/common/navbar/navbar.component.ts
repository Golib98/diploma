import {Component, Input, OnInit} from '@angular/core';
import {MenuItem} from "../../../model/MenuItem";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  @Input() menuItems: MenuItem[];

  constructor() {
  }

  ngOnInit() {
  }

}
