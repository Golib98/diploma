import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {NavbarComponent} from './navbar.component';
import {HomeRoutingModule} from "../../pages/home/home-routing.module";
import {FlexLayoutModule} from "@angular/flex-layout";
import {MatButtonModule, MatToolbarModule} from "@angular/material";

@NgModule({
  declarations: [NavbarComponent],
  imports: [
    CommonModule,
    HomeRoutingModule,
    FlexLayoutModule,
    MatButtonModule,
    MatToolbarModule
  ],
  exports: [
    NavbarComponent
  ]
})
export class NavbarModule {
}
