import {NgModule} from '@angular/core';

import {LoginComponent} from './login.component';
import {LoginService} from "./login.service";
import {CommonModule} from "@angular/common";
import {RouterModule} from "@angular/router";
import {LoginRoutingModule} from "./login-routing.module";
import {FormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatButtonModule, MatInputModule} from "@angular/material";
import {FlexLayoutModule} from "@angular/flex-layout";

@NgModule({
  declarations: [LoginComponent],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    LoginRoutingModule,
    FlexLayoutModule,
  ],
  providers: [LoginService],
  exports: [RouterModule, LoginComponent]
})
export class LoginModule {
}
