import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {MyAssistantsRoutingModule} from './my-assistants-routing.module';
import {MyAssistantsComponent} from './my-assistants.component';
import {NavbarModule} from "../../common/navbar/navbar.module";
import {FlexLayoutModule} from "@angular/flex-layout";
import {MyAssistantCardComponent} from './components/my-assistant-card/my-assistant-card.component';
import {
  MatButtonModule,
  MatCardModule,
  MatDialogModule,
  MatFormFieldModule,
  MatInputModule,
  MatTabsModule
} from "@angular/material";
import {RespondsComponent} from './components/responds/responds.component';
import {SendMailDialogComponent} from './components/send-mail-dialog/send-mail-dialog.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [MyAssistantsComponent, MyAssistantCardComponent, RespondsComponent, SendMailDialogComponent],
  imports: [
    CommonModule,
    MyAssistantsRoutingModule,
    NavbarModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    FlexLayoutModule,
    MatCardModule,
    MatButtonModule,
    MatDialogModule,
    MatTabsModule,
  ],
  entryComponents: [
    SendMailDialogComponent,
  ]
})
export class MyAssistantsModule {
}
