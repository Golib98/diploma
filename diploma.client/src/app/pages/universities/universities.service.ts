import {Injectable} from '@angular/core';
import {HttpService} from "../../services/http.service";
import {UniversityCardInfo} from "../../../model/UniversityCardInfo";
import {map} from "rxjs/operators";
import {HttpResponse} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class UniversitiesService {

  constructor(private http: HttpService) {
  }

  public get universities(): Promise<UniversityCardInfo[]> {

    return this.http.get('/universities/getAllUniversities')
      .pipe(map<HttpResponse<any>, UniversityCardInfo[]>(k => k.body))
      .toPromise();
  }
}
