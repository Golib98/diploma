import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";

@Component({
  selector: 'app-popup-ask',
  templateUrl: './popup-ask.component.html',
  styleUrls: ['./popup-ask.component.scss']
})
export class PopupAskComponent implements OnInit {

  constructor(public popupComponentMatDialogRef: MatDialogRef<PopupAskComponent>,
              @Inject(MAT_DIALOG_DATA) public data: string) {
  }

  ngOnInit() {
  }

  onCancelClick(): void {
    this.popupComponentMatDialogRef.close();
  }

}

