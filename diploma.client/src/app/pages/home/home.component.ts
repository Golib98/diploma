import {Component} from '@angular/core';
import {MenuItem} from "../../../model/MenuItem";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {

  menuItems = [
    MenuItem.of("Universities", "/universities"),
    MenuItem.of("Rankings", ""),
    MenuItem.of("Best Students", ""),
    MenuItem.of("News", ""),
    MenuItem.of("Jobs", ""),
    MenuItem.of("About", ""),
    MenuItem.of("Help", ""),
    MenuItem.of("Login/Sign Up", "/registration"),
  ];


  constructor() {
  }
}
