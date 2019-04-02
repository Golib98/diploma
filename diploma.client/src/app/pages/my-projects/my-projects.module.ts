import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {MyProjectsRoutingModule} from './my-projects-routing.module';
import {MyProjectsComponent} from './my-projects.component';
import {NavbarModule} from "../../common/navbar/navbar.module";
import {MyProjectCardComponent} from './components/my-project-card/my-project-card.component';
import {FlexLayoutModule} from "@angular/flex-layout";
import {
  MatButtonModule,
  MatCardModule,
  MatCheckboxModule,
  MatDialogModule,
  MatFormFieldModule,
  MatInputModule,
  MatMenuModule
} from "@angular/material";
import {PopupModule} from "../../common/popup/popup.module";
import {MyProjectEditDialogComponent} from './components/my-project-edit-dialog/my-project-edit-dialog.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [MyProjectsComponent, MyProjectCardComponent, MyProjectEditDialogComponent],
  imports: [
    CommonModule,
    MyProjectsRoutingModule,
    NavbarModule,
    PopupModule,
    FlexLayoutModule,
    MatCardModule,
    MatButtonModule,
    MatMenuModule,
    MatDialogModule,
    MatCheckboxModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
  ],
  entryComponents: [
    MyProjectEditDialogComponent,
  ]
})
export class MyProjectsModule {
}
