import {Injectable} from '@angular/core';
import {HttpService} from "../../services/http.service";
import {MyProjectCard} from "../../../model/MyProjectCard";
import {map} from "rxjs/operators";
import {MyProjectDetail} from "../../../model/MyProjectDetail";

@Injectable({
  providedIn: 'root'
})
export class MyProjectsService {

  defaultTimeout: number = 1000;

  constructor(private http: HttpService) {
  }

  get myProjects(): Promise<MyProjectCard[]> {

    return this.http.get("/projects/myProjects")
      .pipe(map<any, MyProjectCard[]>(k => k.body))
      .toPromise();

  }

  deleteMyProject(id: string): Promise<void> {
    return this.http.get("/projects/deleteProject", {projectId: id})
      .toPromise()
      .then(res => null);
  }

  updateProject(myProject: MyProjectCard): Promise<void> {

    let myProjectDetail = new MyProjectDetail();
    myProjectDetail.title = myProject.title;
    myProjectDetail.description = myProject.description;
    myProjectDetail.id = myProject.id;

    return this.http.post('/projects/addProject', {project: JSON.stringify(myProjectDetail)})
      .toPromise()
      .then(res => null);
  }
}
