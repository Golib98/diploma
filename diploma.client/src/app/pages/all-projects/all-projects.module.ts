import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {AllProjectsRoutingModule} from './all-projects-routing.module';
import {AllProjectsComponent} from './all-projects.component';
import {NavbarModule} from "../../common/navbar/navbar.module";
import {FlexLayoutModule} from "@angular/flex-layout";
import {AllProjectCardComponent} from './components/all-project-card/all-project-card.component';
import {MatButtonModule, MatCardModule, MatFormFieldModule, MatInputModule, MatMenuModule} from "@angular/material";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [AllProjectsComponent, AllProjectCardComponent],
  imports: [
    CommonModule,
    NavbarModule,
    FlexLayoutModule,
    AllProjectsRoutingModule,
    MatCardModule,
    MatButtonModule,
    MatMenuModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
  ]
})
export class AllProjectsModule {
}
