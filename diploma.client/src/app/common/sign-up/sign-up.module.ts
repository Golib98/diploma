import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SignUpComponent} from './sign-up.component';
import {FlexLayoutModule} from "@angular/flex-layout";
import {MatButtonModule, MatInputModule, MatSelectModule} from "@angular/material";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [SignUpComponent],
  imports: [
    CommonModule,
    FlexLayoutModule,
    MatSelectModule,
    MatInputModule,
    MatButtonModule,
    FormsModule,
  ],
  exports: [
    SignUpComponent
  ]
})
export class SignUpModule {
}
