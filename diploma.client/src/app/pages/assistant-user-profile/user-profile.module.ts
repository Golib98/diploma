import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {UserProfileRoutingModule} from './user-profile-routing.module';
import {UserProfileComponent} from './user-profile.component';
import {NavbarModule} from "../../common/navbar/navbar.module";
import {FlexLayoutModule} from "@angular/flex-layout";
import {MatButtonModule, MatCardModule} from "@angular/material";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    UserProfileComponent,
  ],
  imports: [
    CommonModule,
    NavbarModule,
    FlexLayoutModule,
    MatCardModule,
    MatButtonModule,
    UserProfileRoutingModule,
    FormsModule,
  ]
})
export class UserProfileModule {
}
