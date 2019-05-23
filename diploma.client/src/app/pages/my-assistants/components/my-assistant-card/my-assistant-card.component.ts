import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {MyAssistantCard} from "../../../../../model/MyAssistantCard";
import {MatDialog} from "@angular/material";
import {SendMailDialogComponent} from "../send-mail-dialog/send-mail-dialog.component";

@Component({
  selector: 'app-my-assistant-card',
  templateUrl: './my-assistant-card.component.html',
  styleUrls: ['./my-assistant-card.component.scss']
})
export class MyAssistantCardComponent implements OnInit {

  @Input() myAssistant: MyAssistantCard;
  @Output() sendMailButtonEmitter = new EventEmitter<{ topic: string, body: string }>();
  @Output() refusingButtonEmitter = new EventEmitter<void>();

  constructor(private matDialog: MatDialog) {
  }

  ngOnInit() {
  }

  openDialog() {

    this.matDialog.open(SendMailDialogComponent, {
      width: '60%',
      height: '80%'
    }).afterClosed().subscribe(value => {
      console.log(value);
      if (value.body && value.topic) {
        this.sendMailButtonEmitter.emit(value);
      }
    })


  }
}
