import {Component, Input, OnInit} from '@angular/core';
import {MenuItem} from "../../../model/MenuItem";
import {LoginService} from "../login/login.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  @Input() menuItems: MenuItem[];

  linkToProfile = '';

  constructor(public loginService: LoginService,
              private router: Router,) {
  }

  async ngOnInit() {
    await this.loginService.start();
    if (!this.loginService.isAuthenticated) {
      return
    }

    if (this.loginService.personDisplay.role === 'STUDENT') {
      this.linkToProfile = '/assistant-user-profile'
    }
    if (this.loginService.personDisplay.role === 'PROFESSOR') {
      this.linkToProfile = '/professor-user-profile'
    }
  }

  logOut() {
    this.loginService.exit()
      .then(() => this.router.navigate(['/home']))
      .then(() => window.location.reload())
  }
}
