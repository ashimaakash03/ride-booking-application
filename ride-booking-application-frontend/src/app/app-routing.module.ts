import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {RegistrationComponent} from "./components/registration/registration.component";
import {LoginComponent} from "./components/login/login.component";
import {BookingsComponent} from "./components/bookings/bookings.component";
import {BookingHistoryComponent} from "./components/booking-history/booking-history.component";

const routes: Routes = [
	{path: '', component: RegistrationComponent, pathMatch: 'full'},
	{path: 'sign-up', component: RegistrationComponent, pathMatch: 'full'},
	{path: 'sign-in', component: LoginComponent, pathMatch: 'full'},
	{path: 'booking', component: BookingsComponent, pathMatch: 'full'},
	{path: 'history', component: BookingHistoryComponent, pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
