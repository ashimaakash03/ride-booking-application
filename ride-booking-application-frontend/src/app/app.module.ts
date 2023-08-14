import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HeaderComponent} from './components/header/header.component';
import {RegistrationComponent} from './components/registration/registration.component';
import {LoginComponent} from './components/login/login.component';
import {ReactiveFormsModule} from "@angular/forms";
import {FooterComponent} from './components/footer/footer.component';
import {BookingsComponent} from './components/bookings/bookings.component';
import {BookingHistoryComponent} from './components/booking-history/booking-history.component';
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
	  AppComponent,
	  HeaderComponent,
	  RegistrationComponent,
	  LoginComponent,
	  FooterComponent,
	  BookingsComponent,
	  BookingHistoryComponent,
  ],
	imports: [
		BrowserModule,
		AppRoutingModule,
		BrowserAnimationsModule,
		ReactiveFormsModule,
		HttpClientModule
	],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
