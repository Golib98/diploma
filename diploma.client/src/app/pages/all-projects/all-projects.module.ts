import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {AllProjectsRoutingModule} from './all-projects-routing.module';
import {AllProjectsComponent} from './all-projects.component';
import {NavbarModule} from "../../common/navbar/navbar.module";
import {FlexLayoutModule} from "@angular/flex-layout";
import {AllProjectCardComponent} from './components/all-project-card/all-project-card.component';
import {
  MatAutocompleteModule,
  MatButtonModule,
  MatCardModule,
  MatDatepickerModule,
  MatFormFieldModule,
  MatInputModule,
  MatMenuModule,
  MatNativeDateModule
} from "@angular/material";
import {FormsModule} from "@angular/forms";
import {AllProjectsFilterComponent} from './components/all-projects-filter/all-projects-filter.component';

@NgModule({
  declarations: [AllProjectsComponent, AllProjectCardComponent, AllProjectsFilterComponent],
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
    MatNativeDateModule,
    MatDatepickerModule,
    MatAutocompleteModule,
    FormsModule,
  ]
})
export class AllProjectsModule {
}
