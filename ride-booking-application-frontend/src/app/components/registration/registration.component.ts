import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {UserService} from "../../services/user.service";
import {User} from "../../models/user";
import {Router} from "@angular/router";

@Component({
	selector: 'app-registration',
	templateUrl: './registration.component.html',
	styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
    users: User[] = [];
	registrationForm: FormGroup;

	constructor(private formBuilder: FormBuilder, private userService: UserService, private router: Router) {
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
        this.userService.addUser(this.registrationForm.value).subscribe((data) => {
			this.users.push(data);
            alert("User Registered");
			this.router.navigate(['/login']);
        })
	}
}
