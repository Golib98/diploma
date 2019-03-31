import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {PopupComponent} from './popup.component';
import {MatButtonModule, MatDialogModule, MatFormFieldModule, MatInputModule} from "@angular/material";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [PopupComponent],
  imports: [
    CommonModule,
    MatDialogModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
  ],
  exports: [
    PopupComponent,
  ],
  entryComponents: [
    PopupComponent
  ]
})
export class PopupModule {
}
