import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AllAssistantsComponent} from "./all-assistants.component";

const routes: Routes = [{
  path: '',
  component: AllAssistantsComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AllAssistantsRoutingModule {
}
