import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
	selector: 'app-bookings',
	templateUrl: './bookings.component.html',
	styleUrls: ['./bookings.component.css']
})
export class BookingsComponent implements OnInit {

	bookingForm: FormGroup;

	constructor(private formBuilder: FormBuilder) {
		this.bookingForm = this.formBuilder.group({
			fullname: ['', [Validators.required]],
			contact: ['', [Validators.required, Validators.pattern]],
			fromlocation: ['', [Validators.required]],
			tolocation: ['', [Validators.required]],
			vehicle: ['', [Validators.required]]
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

}
