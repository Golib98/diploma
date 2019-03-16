import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HttpService} from "./services/http.service";
import {HttpClientModule} from "@angular/common/http";
import {RoutingModule} from "./routing.module";
import {RouterModule} from "@angular/router";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule,
    RoutingModule,
    BrowserAnimationsModule
  ],
  providers: [HttpService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
