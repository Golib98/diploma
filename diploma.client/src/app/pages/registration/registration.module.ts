import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {RegistrationRoutingModule} from './registration-routing.module';
import {RegistrationComponent} from './registration.component';
import {SignUpModule} from "../../common/sign-up/sign-up.module";
import {NavbarModule} from "../../common/navbar/navbar.module";
import {FlexLayoutModule} from "@angular/flex-layout";
import {LoginModule} from "../../common/login/login.module";

@NgModule({
  declarations: [RegistrationComponent],
  imports: [
    CommonModule,
    SignUpModule,
    NavbarModule,
    FlexLayoutModule,
    LoginModule,
    RegistrationRoutingModule
  ]
})
export class RegistrationModule {
}
