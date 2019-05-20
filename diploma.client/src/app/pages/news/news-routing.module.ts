import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {NewsComponent} from "./news.component";
import {NewsDetailsComponent} from "./news-details/components/news-details.component";

const routes: Routes = [
  {
    path: '',
    component: NewsComponent,
  },
  {
    path: 'details/:id',
    component: NewsDetailsComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NewsRoutingModule {
}
