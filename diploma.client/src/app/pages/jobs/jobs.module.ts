import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {JobsRoutingModule} from './jobs-routing.module';
import {JobsComponent} from './jobs.component';
import {NavbarModule} from "../../common/navbar/navbar.module";
import {FlexLayoutModule} from "@angular/flex-layout";
import {MatCardModule} from "@angular/material";

@NgModule({
  declarations: [JobsComponent],
  imports: [
    CommonModule,
    JobsRoutingModule,
    NavbarModule,
    FlexLayoutModule,
    MatCardModule,
  ]
})
export class JobsModule {
}
