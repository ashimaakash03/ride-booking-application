import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
	selector: 'app-registration',
	templateUrl: './registration.component.html',
	styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

	registrationForm: FormGroup;

	constructor(private formBuilder: FormBuilder) {
		this.registrationForm = this.formBuilder.group({
			fullname: ['', [Validators.required]],
			contact: ['', [Validators.required, Validators.pattern]],
			email: ['', [Validators.required, Validators.pattern]],
			password: ['', [Validators.required]]
		});
	}

	ngOnInit(): void {
		let submitForm = document.querySelector('form') as HTMLFormElement;
		submitForm.addEventListener('submit', (submitEvent: SubmitEvent) => {
			if (!submitForm.checkValidity()) {
				submitEvent.preventDefault();
				submitEvent.stopPropagation();
			}
			submitForm.classList.add('was-validated');
			submitForm.reset();
		});
	}

	registerUser() {

	}
}
