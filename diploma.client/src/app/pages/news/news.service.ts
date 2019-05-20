import {Injectable} from '@angular/core';
import {News} from "../../../model/News";
import {HttpService} from "../../services/http.service";
import {map} from "rxjs/operators";

@Injectable()
export class NewsService {

  constructor(private http: HttpService) {
  }

  allNews: News[] = [];

  get news(): Promise<News[]> {

    return this.http.get('/news/getAll')
      .pipe(map<any, News[]>(k => k.body))
      .toPromise()
      .then(value => this.allNews = value);
  }
}
