import {Component, OnInit} from '@angular/core';
import {LoginService} from "./login.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  constructor(public loginService: LoginService,
              private router: Router) {
  }

  async ngOnInit() {
    await this.loginService.start();
  }

  login() {
    this.loginService.login()
      .then(ignore => {
        if (!this.loginService.isAuthenticated) return;

        if (this.loginService.personDisplay.role === 'STUDENT') {
          this.router.navigate(['/assistant-user-profile'])
        }

        if (this.loginService.personDisplay.role === 'PROFESSOR') {
          this.router.navigate(['/professor-user-profile']);
        }
      })
  }
}
