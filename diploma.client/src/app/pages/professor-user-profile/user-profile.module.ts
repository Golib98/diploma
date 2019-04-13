import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {UserProfileRoutingModule} from './user-profile-routing.module';
import {UserProfileComponent} from './user-profile.component';
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
  MatTabsModule
} from "@angular/material";
import {NewProjectComponent} from './components/new-project/new-project.component';
import {FormsModule} from "@angular/forms";
import {PopupModule} from "../../common/popup/popup.module";

@NgModule({
  declarations: [
    UserProfileComponent,
    NewProjectComponent],
  imports: [
    CommonModule,
    NavbarModule,
    FlexLayoutModule,
    MatTabsModule,
    MatFormFieldModule,
    MatInputModule,
    MatCheckboxModule,
    MatButtonModule,
    UserProfileRoutingModule,
    FormsModule,
    PopupModule,
    MatCardModule,
    MatNativeDateModule,
    MatDatepickerModule,
    MatIconModule,
  ]
})
export class UserProfileModule {
}
