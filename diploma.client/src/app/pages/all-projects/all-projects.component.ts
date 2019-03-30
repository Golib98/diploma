import {Component, OnInit} from '@angular/core';
import {AllProjectCard} from "../../../model/AllProjectCard";

@Component({
  selector: 'app-all-projects',
  templateUrl: './all-projects.component.html',
  styleUrls: ['./all-projects.component.scss']
})
export class AllProjectsComponent implements OnInit {
  myProjects: AllProjectCard[];

  constructor() {
  }

  ngOnInit() {
  }

}
