import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {UniversitiesRoutingModule} from './universities-routing.module';
import {UniversitiesComponent} from './universities.component';
import {FlexLayoutModule} from "@angular/flex-layout";
import {NavbarModule} from "../../common/navbar/navbar.module";
import {UniversityCardComponent} from './components/university-card/university-card.component';
import {MatButtonModule, MatCardModule} from "@angular/material";

@NgModule({
  declarations: [UniversitiesComponent, UniversityCardComponent],
  imports: [
    CommonModule,
    UniversitiesRoutingModule,
    FlexLayoutModule,
    NavbarModule,
    MatCardModule,
    MatButtonModule,
  ]
})
export class UniversitiesModule {
}
