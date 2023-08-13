import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
	selector: 'app-registration',
	templateUrl: './registration.component.html',
	styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

	registrationForm: FormGroup;

	constructor(private formBuilder: FormBuilder) {
		this.registrationForm = this.formBuilder.group({});
	}

	ngOnInit(): void {

	}

}
