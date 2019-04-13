import {Injectable} from '@angular/core';
import {HttpService} from "../../services/http.service";
import {AllProjectCard} from "../../../model/AllProjectCard";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class FavoriteProjectsService {

  constructor(private http: HttpService) {
  }

  public get favoriteProjects(): Promise<AllProjectCard[]> {
    return this.http.get('/projects/favorite')
      .pipe(map<any, AllProjectCard[]>(k => k.body))
      .toPromise();
  }
}
