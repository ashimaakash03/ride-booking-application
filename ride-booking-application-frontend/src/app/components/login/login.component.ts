import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {User} from "../../models/user";
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";

@Component({
	selector: 'app-login',
	templateUrl: './login.component.html',
	styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
	user: User = new User(0, "", "", "", "");
	loginForm: FormGroup;
	isUserLoggedIn: boolean = false;

	constructor(private formBuilder: FormBuilder, private userService: UserService, private router: Router) {
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
	loginUser() {
		// 	this.userService.loginUser(this.loginForm.value).subscribe((data) => {
		// 		const user = data.find((anyUser: User) => {
		// 			return anyUser.email === this.loginForm.value.email && anyUser.password === this.loginForm.value.password
		// 		})
		// 		if (user) {
		// 			alert("Login Success");
		// 			this.router.navigate(['/booking']);
		// 		}
		// 	})
	}
}
