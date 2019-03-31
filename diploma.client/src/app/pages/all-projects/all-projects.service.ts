import {Injectable} from '@angular/core';
import {HttpService} from "../../services/http.service";
import {map} from "rxjs/operators";
import {AllProjectCard} from "../../../model/AllProjectCard";

@Injectable({
  providedIn: 'root'
})
export class AllProjectsService {

  constructor(private httpService: HttpService) {
  }

  public get allProjects(): Promise<AllProjectCard[]> {
    return this.httpService.get('/projects/allProjects')
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
}
