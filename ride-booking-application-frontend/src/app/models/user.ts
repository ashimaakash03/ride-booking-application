export class User {
	id: number;
	fullname: string;
	contact: string;
	email: string;
	password: string;

	constructor(id: number, fullname: string, contact: string, email: string, password: string) {
		this.id = id;
		this.fullname = fullname;
		this.contact = contact;
		this.email = email;
		this.password = password;
	}
}
