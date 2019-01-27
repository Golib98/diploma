import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SignUpComponent} from './sign-up.component';
import {FlexLayoutModule} from "@angular/flex-layout";
import {MatInputModule, MatSelectModule} from "@angular/material";

@NgModule({
  declarations: [SignUpComponent],
  imports: [
    CommonModule,
    FlexLayoutModule,
    MatSelectModule,
    MatInputModule,
  ],
  exports:[
    SignUpComponent
  ]
})
export class SignUpModule {
}
