import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {AccessedProjectsService} from "../../accessed-projects.service";
import {ProjectDetails} from "../../../../../model/ProjectDetails";
import {HttpService} from "../../../../services/http.service";

@Component({
  selector: 'app-accessed-project-details',
  templateUrl: './accessed-project-details.component.html',
  styleUrls: ['./accessed-project-details.component.scss']
})
export class AccessedProjectDetailsComponent implements OnInit {

  project: ProjectDetails;

  constructor(public dialogRef: MatDialogRef<AccessedProjectDetailsComponent>,
              @Inject(MAT_DIALOG_DATA) public projectId: string,
              private service: AccessedProjectsService,
              public http: HttpService) {
  }

  ngOnInit() {
    this.service.getProjectDetail(this.projectId).then(value => {
      this.project = value;
      console.log(value);
    });
  }

  downloadFile(id: string) {
    this.http.downloadResource('/files/get', {fileId: id})
      .then(value => console.log(value));
  }
}
