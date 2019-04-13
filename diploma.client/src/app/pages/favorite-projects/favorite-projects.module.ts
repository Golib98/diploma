import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {FavoriteProjectsRoutingModule} from './favorite-projects-routing.module';
import {FavoriteProjectsComponent} from './favorite-projects.component';
import {MatButtonModule, MatCardModule, MatFormFieldModule} from "@angular/material";
import {NavbarModule} from "../../common/navbar/navbar.module";
import {FavoriteProjectComponent} from './components/favorite-project/favorite-project.component';
import {FlexLayoutModule} from "@angular/flex-layout";

@NgModule({
  declarations: [FavoriteProjectsComponent, FavoriteProjectComponent],
  imports: [
    CommonModule,
    FavoriteProjectsRoutingModule,
    MatFormFieldModule,
    MatButtonModule,
    NavbarModule,
    MatCardModule,
    FlexLayoutModule,
  ]
})
export class FavoriteProjectsModule {
}
