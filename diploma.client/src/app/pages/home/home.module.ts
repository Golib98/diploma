import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {HomeRoutingModule} from './home-routing.module';
import {HomeComponent} from './home.component';
import {FlexLayoutModule} from "@angular/flex-layout";
import {LoginModule} from "../../common/login/login.module";
import {NavbarModule} from "../../common/navbar/navbar.module";
import {MatButtonModule, MatCardModule} from "@angular/material";
import {RouterModule} from "@angular/router";

@NgModule({
  declarations: [HomeComponent],
  imports: [
    CommonModule,
    HomeRoutingModule,
    NavbarModule,
    FlexLayoutModule,
    MatCardModule,
    MatButtonModule,
    RouterModule,
    LoginModule,
  ]
})
export class HomeModule {
}
