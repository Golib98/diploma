import {Injectable} from '@angular/core';
import {HttpService} from "../../services/http.service";
import {MyProjectDetail} from "../../../model/MyProjectDetail";
import {map} from "rxjs/operators";
import {ProfessorInfo} from "../../../model/ProfessorInfo";
import {FileWrapper} from "../../../model/gen/FileWrapper";

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

  public addFiles(files: FileList): Promise<FileWrapper[]> {

    if (!files) return Promise.resolve(null);

    let ret: Promise<FileWrapper>[] = [];

    for (let i = 0; i < files.length; i++) {
      ret.push(
        this.http.postFile('/files/save', files[i])
          .pipe(map<any, FileWrapper>(k => k.body))
          .toPromise()
      );
    }

    return Promise.all(ret)
  }

  save(professorInfo: ProfessorInfo) {
    return this.http.post('/person/save-professor-info', {professorInfo: JSON.stringify(professorInfo)})
      .pipe(map<any, void>(k => null))
      .toPromise();
  }
}
