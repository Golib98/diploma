import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {NewsRoutingModule} from './news-routing.module';
import {NewsComponent} from './news.component';
import {FlexLayoutModule} from "@angular/flex-layout";
import {NavbarModule} from "../../common/navbar/navbar.module";
import {NewsService} from "./news.service";
import {NewsDetailsComponent} from './news-details/components/news-details.component';
import {MatCardModule, MatGridListModule} from "@angular/material";

@NgModule({
  declarations: [NewsComponent, NewsDetailsComponent],
  imports: [
    CommonModule,
    NewsRoutingModule,
    FlexLayoutModule,
    NavbarModule,
    MatCardModule,
    MatGridListModule,
  ],
  providers: [NewsService]
})
export class NewsModule {
}
