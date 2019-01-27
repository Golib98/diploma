import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";

const routes: Routes = [
  {
    path: 'home',
    loadChildren: './pages/home/home.module#HomeModule'
  },
  {
    path: 'registration',
    loadChildren: './pages/registration/registration.module#RegistrationModule'
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
