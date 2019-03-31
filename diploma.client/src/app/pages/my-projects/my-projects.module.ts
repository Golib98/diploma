import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {MyProjectsRoutingModule} from './my-projects-routing.module';
import {MyProjectsComponent} from './my-projects.component';
import {NavbarModule} from "../../common/navbar/navbar.module";
import {MyProjectCardComponent} from './components/my-project-card/my-project-card.component';
import {FlexLayoutModule} from "@angular/flex-layout";
import {MatButtonModule, MatCardModule, MatDialogModule, MatMenuModule} from "@angular/material";
import {PopupModule} from "../../common/popup/popup.module";

@NgModule({
  declarations: [MyProjectsComponent, MyProjectCardComponent],
  imports: [
    CommonModule,
    MyProjectsRoutingModule,
    NavbarModule,
    FlexLayoutModule,
    MatCardModule,
    MatButtonModule,
    MatMenuModule,
    MatDialogModule,
    PopupModule,
  ]
})
export class MyProjectsModule {
}
