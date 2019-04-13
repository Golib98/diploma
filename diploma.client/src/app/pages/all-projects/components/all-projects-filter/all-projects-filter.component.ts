import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ProfessorDict} from "../../../../../model/gen/ProfessorDict";
import {AllProjectFilter} from "../../../../../model/gen/AllProjectFilter";
import {AllProjectsService} from "../../all-projects.service";

@Component({
  selector: 'app-all-projects-filter',
  templateUrl: './all-projects-filter.component.html',
  styleUrls: ['./all-projects-filter.component.scss']
})
export class AllProjectsFilterComponent implements OnInit {
  projectTitle: string;
  professorValue: string;
  dateUploaded: Date;
  unfilteredProfessors: ProfessorDict[];
  @Input() professors: ProfessorDict[];
  @Output() findButtonEmitted = new EventEmitter<AllProjectFilter>();

  constructor(private allProjectsService: AllProjectsService) {
  }

  ngOnInit() {
    this.allProjectsService.professorsDict.then(value => {
      this.professors = value;
      this.unfilteredProfessors = value;
    });
  }

  emitFind() {
    let filter = new AllProjectFilter();
    let professorDict = this.professors.find(value => value.fio === this.professorValue);
    if (professorDict) filter.professorId = professorDict.id;
    if (this.projectTitle) filter.projectTitle = this.projectTitle;
    if (this.dateUploaded) filter.uploadDate = this.dateUploaded;

    this.findButtonEmitted.emit(filter);
  }

  filter() {
    this.professors = this.unfilteredProfessors.filter(value =>
      value.fio.toLowerCase().includes(this.professorValue.toLowerCase()));
  }
}
