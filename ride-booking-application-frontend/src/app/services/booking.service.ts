import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Booking} from "../models/booking";
import {Observable} from "rxjs";

@Injectable({
	providedIn: 'root'
})
export class BookingService {

	url: string = "http://localhost:3002/bookings";

	constructor(private httpClient: HttpClient) {
	}

	addBooking(booking: Booking): Observable<Array<Booking>> {
		return this.httpClient.post<Array<Booking>>(this.url, booking);
	}
}
