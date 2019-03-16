import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {AllAssistantsRoutingModule} from './all-assistants-routing.module';
import {AllAssistantsComponent} from './all-assistants.component';
import {AssistanceCardComponent} from './components/assistance-card/assistance-card.component';
import {FlexLayoutModule} from "@angular/flex-layout";
import {NavbarModule} from "../../common/navbar/navbar.module";
import {
  MatButtonModule,
  MatCardModule,
  MatDatepickerModule,
  MatInputModule,
  MatNativeDateModule
} from "@angular/material";
import {AssistantsFilterComponent} from './components/assistants-filter/assistants-filter.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [AllAssistantsComponent, AssistanceCardComponent, AssistantsFilterComponent],
  imports: [
    CommonModule,
    AllAssistantsRoutingModule,
    FlexLayoutModule,
    NavbarModule,
    MatCardModule,
    MatButtonModule,
    MatInputModule,
    MatNativeDateModule,
    MatDatepickerModule,
    FormsModule,
  ]
})
export class AllAssistantsModule {
}
