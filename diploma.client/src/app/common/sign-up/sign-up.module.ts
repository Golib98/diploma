import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SignUpComponent} from './sign-up.component';
import {FlexLayoutModule} from "@angular/flex-layout";
import {MatButtonModule, MatDialogModule, MatInputModule, MatSelectModule} from "@angular/material";
import {FormsModule} from "@angular/forms";
import {PopupModule} from "../popup/popup.module";

@NgModule({
  declarations: [SignUpComponent],
  imports: [
    CommonModule,
    FlexLayoutModule,
    MatSelectModule,
    MatInputModule,
    MatButtonModule,
    FormsModule,
    MatDialogModule,
    PopupModule,
  ],
  exports: [
    SignUpComponent
  ]
})
export class SignUpModule {
}
