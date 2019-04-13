import {Injectable} from '@angular/core';
import {HttpService} from "../../services/http.service";
import {AllProjectCard} from "../../../model/AllProjectCard";
import {map} from "rxjs/operators";
import {ProjectDetails} from "../../../model/ProjectDetails";

@Injectable({
  providedIn: 'root'
})
export class AccessedProjectsService {

  constructor(private http: HttpService) {
  }

  public get accessedProjects(): Promise<AllProjectCard[]> {
    return this.http.get("/projects/accessed-projects")
      .pipe(map<any, AllProjectCard[]>(k => k.body))
      .toPromise();
  }

  getProjectDetail(projectId: string): Promise<ProjectDetails> {

    return this.http.get("/projects/detailFor", {id: projectId})
      .pipe(map<any, ProjectDetails>(k => k.body))
      .toPromise();
  }
}
