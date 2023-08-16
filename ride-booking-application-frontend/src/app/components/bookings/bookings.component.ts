import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {BookingService} from "../../services/booking.service";
import {Booking} from "../../models/booking";

@Component({
	selector: 'app-bookings',
	templateUrl: './bookings.component.html',
	styleUrls: ['./bookings.component.css']
})
export class BookingsComponent implements OnInit {

	bookings: Booking[] = [];
	bookingForm: FormGroup;

	constructor(private formBuilder: FormBuilder, private bookingService: BookingService) {
		this.bookingForm = this.formBuilder.group({
			fullname: ['', [Validators.required]],
			contact: ['', [Validators.required, Validators.pattern]],
			fromlocation: ['', [Validators.required]],
			tolocation: ['', [Validators.required]],
			vehicle: ['', [Validators.required]],
			distance: ['', [Validators.required]],
			price: ['', [Validators.required]]
		});
	}

	ngOnInit(): void {
		let submitForm = document.querySelector('form') as HTMLFormElement

		submitForm.addEventListener('submit', (submitEvent: SubmitEvent) => {
			if (!submitForm.checkValidity()) {
				submitEvent.stopPropagation();
				submitEvent.preventDefault();
			}
			submitForm.classList.add('was-validated');
			submitForm.reset();
		});
	}

	addBooking() {
		this.bookingService.addBooking(this.bookingForm.value).subscribe((data) => {
			this.bookings = data;
			alert("Ride Booked");
		})
	}
}
