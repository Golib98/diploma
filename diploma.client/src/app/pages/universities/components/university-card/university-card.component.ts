import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {UniversityCardInfo} from "../../../../../model/UniversityCardInfo";
import {DomSanitizer} from "@angular/platform-browser";

@Component({
  selector: 'app-university-card',
  templateUrl: './university-card.component.html',
  styleUrls: ['./university-card.component.scss']
})
export class UniversityCardComponent implements OnInit {

  @Input() model: UniversityCardInfo;
  @Output() likeButtonEmitter: EventEmitter<VoidFunction>;
  @Output() compareButtonEmitter: EventEmitter<VoidFunction>;

  url;


  constructor(private domSanitizer: DomSanitizer) {
  }

  ngOnInit() {

    console.log(this.model);

    this.url = 'assets/img/' +
      this.model.logo;


  }

}
