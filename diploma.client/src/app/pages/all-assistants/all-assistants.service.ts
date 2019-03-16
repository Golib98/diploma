import {Injectable} from '@angular/core';
import {AllAssistantCard} from "../../../model/AllAssistantCard";
import {HttpService} from "../../services/http.service";
import {map} from "rxjs/operators";
import {AllAssistantsIn} from "../../../model/AllAssistantsIn";

@Injectable({
  providedIn: 'root'
})
export class AllAssistantsService {

  constructor(private http: HttpService) {
  }

  public getAssistantCards(allAssistantsIn: AllAssistantsIn): Promise<AllAssistantCard[]> {
    return this.http.post("/person/allAssistants", {allAssistantsIn: JSON.stringify(allAssistantsIn)})
      .pipe(map<any, any[]>(k => k.body))
      .toPromise()
      .then(res => {
        let ret: AllAssistantCard[] = [];
        res.forEach(value => {
          let toAdd = new AllAssistantCard();
          toAdd.name = value.fio;
          toAdd.photoUrl = value.fio + 'sdaf';
          ret.push(toAdd);
        });
        return ret;
      });
  }
}
