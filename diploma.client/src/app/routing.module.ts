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
    path: 'user-profile',
    loadChildren: './pages/user-profile/user-profile.module#UserProfileModule'
  },
  {
    path: 'my-projects',
    loadChildren: './pages/my-projects/my-projects.module#MyProjectsModule'
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
