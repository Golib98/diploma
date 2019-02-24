import {Injectable} from '@angular/core';
import {MenuItem} from "../../model/MenuItem";
import {LoginService} from "../common/login/login.service";

@Injectable({
  providedIn: 'root'
})
export class MenuListService {

  constructor(private loginService: LoginService) {
  }

  public get menuList(): Promise<MenuItem[]> {

    return this.loginService.refresh()
      .then(() => {
        if (!this.loginService.isAuthenticated) return Promise.resolve(MenuItem.defaultList());
        if (this.loginService.personDisplay.role === 'PROFESSOR') return Promise.resolve(MenuItem.professorList());
      })

  }
}
