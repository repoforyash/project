import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../User';
import { Observable, of } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient) { }

  authenticateURL: string = "http://localhost:8080/authenticate/users";

  authenticate(username: string, password: string): Observable<boolean> {
    const user: User = {
      userName: username, password: password,
      role: '',
      isAccountLocked: false
    };

    return this.http.post<User>(this.authenticateURL, user).pipe(
      map(data => {
        if (data.userName === username && data.password === password) {
          sessionStorage.setItem('username', username);
          sessionStorage.setItem('role', data.role);
          console.log("CORRECT username and password matches")
          return true;
        } else {
          console.log("INCORRECT username and password matches")
          return false;
        }
      }),
      catchError(() => {
        console.log("inside error block");
        //alert("Incorrect Username or Password. Please try again!")
        return of(false);
      })
    );
  }

  isUserLoggedIn(): boolean {
    const user = sessionStorage.getItem('username');
    const role = sessionStorage.getItem('role');
    return !!(user && role);
    //return sessionStorage.getItem('username') !== null?true:false;
  }

  logOut() {
    sessionStorage.removeItem('username');
    sessionStorage.removeItem('role');
  }
}









