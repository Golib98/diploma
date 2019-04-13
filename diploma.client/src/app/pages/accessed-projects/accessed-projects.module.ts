import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {AccessedProjectsRoutingModule} from './accessed-projects-routing.module';
import {AccessedProjectsComponent} from './accessed-projects.component';
import {FlexLayoutModule} from "@angular/flex-layout";
import {NavbarModule} from "../../common/navbar/navbar.module";
import {AccessedProjectComponent} from './components/accessed-project/accessed-project.component';
import {
  MatButtonModule,
  MatCardModule,
  MatDialogModule,
  MatFormFieldModule,
  MatIconModule,
  MatInputModule
} from "@angular/material";
import {AccessedProjectDetailsComponent} from './components/accessed-project-details/accessed-project-details.component';

@NgModule({
  declarations: [AccessedProjectsComponent, AccessedProjectComponent, AccessedProjectDetailsComponent],
  imports: [
    CommonModule,
    AccessedProjectsRoutingModule,
    FlexLayoutModule,
    NavbarModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatDialogModule,
    MatIconModule,
  ],
  entryComponents: [
    AccessedProjectDetailsComponent
  ]
})
export class AccessedProjectsModule {
}
