import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
	selector: 'app-registration',
	templateUrl: './registration.component.html',
	styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

	registrationForm: FormGroup;

	constructor(private formBuilder: FormBuilder, private httpClient: HttpClient, private router: Router) {
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
		});
	}

	registerUser() {
		this.httpClient.post<any>("http://localhost:3000/registered-users", this.registrationForm.value)
			.subscribe(() => {
				alert("Registration Successful");
				this.registrationForm.reset();
				this.router.navigate(['login']);
			});
	}
}
