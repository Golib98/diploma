import {Component, Input, OnInit} from '@angular/core';
import {MenuItem} from "../../../model/MenuItem";
import {LoginService} from "../login/login.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  @Input() menuItems: MenuItem[];

  linkToProfile = '';

  constructor(public loginService: LoginService) {
  }

  async ngOnInit() {
    await this.loginService.start();
    if (this.loginService.personDisplay.role === 'STUDENT') {
      this.linkToProfile = '/assistant-user-profile'
    }
    if (this.loginService.personDisplay.role === 'PROFESSOR') {
      this.linkToProfile = '/professor-user-profile'
    }
  }

  logOut() {
    this.loginService.exit()
  }
}
