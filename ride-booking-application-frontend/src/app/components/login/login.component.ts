import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
	selector: 'app-login',
	templateUrl: './login.component.html',
	styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

	loginForm: FormGroup;

	constructor(private formBuilder: FormBuilder) {
		this.loginForm = this.formBuilder.group({
			email: ['', [Validators.required, Validators.pattern]],
			password: ['', [Validators.required]]
		});
	}

	ngOnInit(): void {
		let submitForm = document.querySelector('form') as HTMLFormElement

		submitForm.addEventListener('submit', (submitEvent: SubmitEvent) => {
			if (!submitForm.checkValidity()) {
				submitEvent.preventDefault();
				submitEvent.stopPropagation();
			}
			submitForm.classList.add('was-validated');
			submitForm.reset();
		});
	}

}
