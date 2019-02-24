import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {NavbarComponent} from './navbar.component';
import {FlexLayoutModule} from "@angular/flex-layout";
import {MatButtonModule, MatToolbarModule} from "@angular/material";
import {RouterModule} from "@angular/router";

@NgModule({
  declarations: [NavbarComponent],
  imports: [
    CommonModule,
    FlexLayoutModule,
    RouterModule,
    MatButtonModule,
    MatToolbarModule
  ],
  exports: [
    NavbarComponent
  ]
})
export class NavbarModule {
}
