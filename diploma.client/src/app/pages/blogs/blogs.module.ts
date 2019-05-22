import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {BlogsRoutingModule} from './blogs-routing.module';
import {BlogsComponent} from './blogs.component';
import {FlexLayoutModule} from "@angular/flex-layout";
import {NavbarModule} from "../../common/navbar/navbar.module";

@NgModule({
  declarations: [BlogsComponent],
  imports: [
    CommonModule,
    BlogsRoutingModule,
    FlexLayoutModule,
    NavbarModule
  ]
})
export class BlogsModule {
}
