import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {PopupAskComponent} from './popup-ask.component';
import {MatButtonModule, MatDialogModule, MatFormFieldModule, MatInputModule} from "@angular/material";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [PopupAskComponent],
  imports: [
    CommonModule,
    MatDialogModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule
  ],
  exports: [PopupAskComponent],
  entryComponents: [PopupAskComponent]
})
export class PopupAskModule {
}
