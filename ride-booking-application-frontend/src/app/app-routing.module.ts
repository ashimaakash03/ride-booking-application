import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {RegistrationComponent} from "./components/registration/registration.component";
import {LoginComponent} from "./components/login/login.component";

const routes: Routes = [
	{path: '', component: RegistrationComponent, pathMatch: 'full'},
	{path: 'sign-up', component: RegistrationComponent},
	{path: 'sign-in', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
