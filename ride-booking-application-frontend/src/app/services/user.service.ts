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
	addUser(user: User): Observable<Array<User>> {
		return this.httpClient.post<Array<User>>(this.url, user);
	}

	loginUser(): Observable<any> {
		return this.httpClient.get(this.url);
	}
}
