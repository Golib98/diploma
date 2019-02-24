import {Injectable} from '@angular/core';
import {HttpService} from "../../services/http.service";
import {MyProject} from "../../../model/MyProject";

@Injectable({
  providedIn: 'root'
})
export class MyProjectsService {

  constructor(private httpService: HttpService) {
  }

  get myProjects(): Promise<MyProject[]> {
    // this.httpService.get()
    let ret: MyProject[] = [];

    let model = new MyProject();
    model.title = 'Title';
    model.desc = 'Description';
    model.updateDate = new Date();
    ret.push(model);

    return new Promise<MyProject[]>(((resolve) => {
      setTimeout(() => {
        resolve(ret);
      }, 1000)
    }));

  }
}
