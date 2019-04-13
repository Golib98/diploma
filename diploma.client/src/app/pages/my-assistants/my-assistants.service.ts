import {Injectable} from '@angular/core';
import {MyAssistantCard} from "../../../model/MyAssistantCard";
import {HttpService} from "../../services/http.service";
import {LoginService} from "../../common/login/login.service";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class MyAssistantsService {

  defaultTimeOut: number = 1000;

  constructor(
    private http: HttpService,
    private loginService: LoginService
  ) {
  }

  public get myAssistants(): Promise<MyAssistantCard[]> {

    return this.http.get("/person/myAssistants",)
      .pipe(map<any, any[]>(k => k.body))
      .toPromise()
      .then(res => {
        let ret: MyAssistantCard[] = [];
        res.forEach(k => {
          let toAdd = new MyAssistantCard();
          toAdd.id = k.id;
          toAdd.name = k.fio;
          toAdd.photoUrl = k.fio + 'url';
          ret.push(toAdd);
        });

        return ret;
      })

  }

  public get myResponds(): Promise<MyAssistantCard[]> {

    return this.http.get("/person/myResponds",)
      .pipe(map<any, MyAssistantCard[]>(k => k.body))
      .toPromise()

  }

  rejectProject(assistantId: string, projectTitle: string): Promise<void> {
    return this.http.get('/projects/rejectProject', {
      assistantId: assistantId,
      projectTitle: projectTitle
    })
      .pipe(map<any, void>(k => k.body))
      .toPromise();
  }

  acceptProject(assistantId: string, projectTitle: string): Promise<void> {
    return this.http.get('/projects/acceptProject', {
      assistantId: assistantId,
      projectTitle: projectTitle
    })
      .pipe(map<any, void>(k => k.body))
      .toPromise();
  }
}
