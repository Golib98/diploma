import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {BlogsArticleComponent} from "./blogs-article.component";

const routes: Routes = [
  {
    path: '',
    component: BlogsArticleComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BlogsArticleRoutingModule {
}
