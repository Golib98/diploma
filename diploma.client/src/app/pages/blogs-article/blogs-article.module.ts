import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {BlogsArticleRoutingModule} from './blogs-article-routing.module';
import {BlogsArticleComponent} from './blogs-article.component';
import {NavbarModule} from "../../common/navbar/navbar.module";
import {FlexLayoutModule} from "@angular/flex-layout";
import {
  MatButtonModule,
  MatCardModule,
  MatCheckboxModule,
  MatDatepickerModule,
  MatFormFieldModule,
  MatIconModule,
  MatInputModule,
  MatNativeDateModule,
  MatSelectModule,
  MatTabsModule
} from "@angular/material";
import {FormsModule} from "@angular/forms";
import {PopupModule} from "../../common/popup/popup.module";

@NgModule({
  declarations: [BlogsArticleComponent],
  imports: [
    CommonModule,
    BlogsArticleRoutingModule,
    NavbarModule,
    FlexLayoutModule,
    MatSelectModule,
    MatTabsModule,
    MatFormFieldModule,
    MatInputModule,
    MatCheckboxModule,
    MatButtonModule,
    FormsModule,
    PopupModule,
    MatCardModule,
    MatNativeDateModule,
    MatDatepickerModule,
    MatIconModule,
  ]
})
export class BlogsArticleModule {
}
