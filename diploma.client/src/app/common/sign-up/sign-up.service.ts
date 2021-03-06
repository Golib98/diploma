import {Injectable} from '@angular/core';
import {HttpService} from "../../services/http.service";
import {RegistrationDict} from "../../../model/RegistrationDict";
import {map} from "rxjs/operators";
import {UserToSave} from "../../../model/UserToSave";

@Injectable({
  providedIn: 'root'
})
export class SignUpService {

  constructor(private http: HttpService) {
  }


  public get dict(): Promise<RegistrationDict> {

    return this.http.get('/dict/registration')
      .pipe(map<any, RegistrationDict>(res => res.body))
      .toPromise();

  }

  signup(userToSave: UserToSave): Promise<void> {

    console.log({userToSave});

    return this.http.post('/auth/signup', {userToSave: JSON.stringify(userToSave)})
      .pipe(map<any, void>(k => k.body))
      .toPromise();

  }
}
