import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../models/user";

@Injectable({
	providedIn: 'root'
})
export class UserService {
	url: string = "http://localhost:3000/registered-users";

	constructor(private httpClient: HttpClient) {
	}

	addUser(user: User): Observable<User> {
		return this.httpClient.post<User>(this.url, user);
	}

	loginUser(user: User): Observable<User> {
		return this.httpClient.post<User>(this.url, user);
	}
}
