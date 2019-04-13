import {Injectable} from '@angular/core';
import {HttpService} from "../../services/http.service";
import {map} from "rxjs/operators";
import {AllProjectCard} from "../../../model/AllProjectCard";
import {ProfessorDict} from "../../../model/gen/ProfessorDict";
import {AllProjectFilter} from "../../../model/gen/AllProjectFilter";

@Injectable({
  providedIn: 'root'
})
export class AllProjectsService {

  constructor(private httpService: HttpService) {
  }

  public allProjects(filter: AllProjectFilter): Promise<AllProjectCard[]> {
    return this.httpService.get('/projects/allProjects', {allProjectFilter: JSON.stringify(filter)})
      .pipe(map<any, AllProjectCard[]>(k => k.body))
      .toPromise();
  }

  likeProject(id: string): Promise<void> {
    return this.httpService.get('/projects/likeProject', {projectId: id})
      .pipe(map<any, void>(k => k))
      .toPromise();
  }

  dislikeProject(id: string): Promise<void> {
    return this.httpService.get('/projects/dislikeProject', {projectId: id})
      .pipe(map<any, void>(k => k))
      .toPromise();
  }

  get professorsDict(): Promise<ProfessorDict[]> {
    return this.httpService.get('/projects/professorsDict')
      .pipe(map<any, ProfessorDict[]>(k => k.body))
      .toPromise();
  }

  respond(projectId: string): Promise<void> {

    return this.httpService.get("/projects/toRespond", {projectId: projectId})
      .pipe(map<any, void>(k => k.body))
      .toPromise()

  }
}
