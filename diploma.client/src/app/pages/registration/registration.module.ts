import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {RegistrationRoutingModule} from './registration-routing.module';
import {RegistrationComponent} from './registration.component';
import {SignUpModule} from "../../common/sign-up/sign-up.module";

@NgModule({
  declarations: [RegistrationComponent],
  imports: [
    CommonModule,
    SignUpModule,
    RegistrationRoutingModule
  ]
})
export class RegistrationModule {
}
