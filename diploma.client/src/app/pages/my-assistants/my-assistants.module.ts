import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {MyAssistantsRoutingModule} from './my-assistants-routing.module';
import {MyAssistantsComponent} from './my-assistants.component';
import {NavbarModule} from "../../common/navbar/navbar.module";
import {FlexLayoutModule} from "@angular/flex-layout";
import {MyAssistantCardComponent} from './components/my-assistant-card/my-assistant-card.component';
import {MatButtonModule, MatCardModule, MatTabsModule} from "@angular/material";
import {RespondsComponent} from './components/responds/responds.component';

@NgModule({
  declarations: [MyAssistantsComponent, MyAssistantCardComponent, RespondsComponent],
  imports: [
    CommonModule,
    MyAssistantsRoutingModule,
    NavbarModule,
    FlexLayoutModule,
    MatCardModule,
    MatButtonModule,
    MatTabsModule,
  ]
})
export class MyAssistantsModule {
}
