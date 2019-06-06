import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";

const routes: Routes = [
  {
    path: 'home',
    loadChildren: './pages/home/home.module#HomeModule'
  },
  {
    path: 'universities',
    loadChildren: './pages/universities/universities.module#UniversitiesModule'
  },
  {
    path: 'registration',
    loadChildren: './pages/registration/registration.module#RegistrationModule'
  },
  {
    path: 'professor-user-profile',
    loadChildren: './pages/professor-user-profile/user-profile.module#UserProfileModule'
  },
  {
    path: 'assistant-user-profile',
    loadChildren: './pages/assistant-user-profile/user-profile.module#UserProfileModule'
  },
  {
    path: 'my-projects',
    loadChildren: './pages/my-projects/my-projects.module#MyProjectsModule'
  },
  {
    path: 'my-assistants',
    loadChildren: './pages/my-assistants/my-assistants.module#MyAssistantsModule'
  },
  {
    path: 'all-assistants',
    loadChildren: './pages/all-assistants/all-assistants.module#AllAssistantsModule'
  },
  {
    path: 'all-projects',
    loadChildren: './pages/all-projects/all-projects.module#AllProjectsModule'
  },
  {
    path: 'favorite-projects',
    loadChildren: './pages/favorite-projects/favorite-projects.module#FavoriteProjectsModule'
  },
  {
    path: 'accessed-projects',
    loadChildren: './pages/accessed-projects/accessed-projects.module#AccessedProjectsModule'
  },
  {
    path: 'news',
    loadChildren: './pages/news/news.module#NewsModule'
  },
  {
    path: 'jobs',
    loadChildren: './pages/jobs/jobs.module#JobsModule'
  },
  {
    path: 'blogs',
    loadChildren: './pages/blogs/blogs.module#BlogsModule'
  },
  {
    path: 'blogs-article',
    loadChildren: './pages/blogs-article/blogs-article.module#BlogsArticleModule'
  },
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class RoutingModule {
}
