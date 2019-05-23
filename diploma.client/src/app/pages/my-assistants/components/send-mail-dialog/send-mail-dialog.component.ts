import {Component, OnInit} from '@angular/core';
import {MatDialogRef} from "@angular/material";

@Component({
  selector: 'app-send-mail-dialog',
  templateUrl: './send-mail-dialog.component.html',
  styleUrls: ['./send-mail-dialog.component.scss']
})
export class SendMailDialogComponent implements OnInit {

  constructor(private componentMatDialogRef: MatDialogRef<SendMailDialogComponent>) {
  }

  body = '';
  topic = '';

  ngOnInit() {

  }

  sendMail() {

    this.componentMatDialogRef.close({body: this.body, topic: this.topic})


  }
}
