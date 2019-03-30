import {Injectable} from '@angular/core';
import {HttpService} from "../../services/http.service";
import {MyProjectDetail} from "../../../model/MyProjectDetail";
import {map} from "rxjs/operators";
import {ProfessorInfo} from "../../../model/ProfessorInfo";

@Injectable({
  providedIn: 'root'
})
export class UserProfileService {

  constructor(private http: HttpService) {
  }

  public addProject(project: MyProjectDetail): Promise<void> {
    return this.http.post("/projects/addProject", {project: JSON.stringify(project)})
      .pipe(map<any, void>(k => k))
      .toPromise();
  }

  public get professorInfo(): Promise<ProfessorInfo> {
    return this.http.get("/person/professorInfo")
      .pipe(map<any, ProfessorInfo>(k => k.body))
      .toPromise();
  }
}
