import {Injectable} from '@angular/core';
import {HttpService} from "../../services/http.service";
import {MyProjectDetail} from "../../../model/MyProjectDetail";
import {map} from "rxjs/operators";
import {StudentInfo} from "../../../model/StudentInfo";

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

  public get studentInfo(): Promise<StudentInfo> {
    return this.http.get("/person/studentInfo")
      .pipe(map<any, StudentInfo>(k => k.body))
      .toPromise();
  }

}
