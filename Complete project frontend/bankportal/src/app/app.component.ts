import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from './service/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Bank Lending Portal';
  username: string = '';
  password: string = '';
  invalidLogin = false
  loginError:string ='';

  constructor(private router: Router,
    private loginservice: AuthenticationService) { }

  ngOnInit() {
    if(this.loginservice.isUserLoggedIn()){
      this.router.navigate(['home'])
    }
  }

 
checkLogin() {
  this.loginservice.authenticate(this.username, this.password).subscribe(authenticated => {
    if (authenticated) {
      this.router.navigate(['home']);
      console.log("Inside home component");
      this.loginError='';
      // this.invalidLogin = false;
    } else {
      this.loginError='Incorrect Username or Password. Please try again!';
      console.log("Error logging in");
      this.invalidLogin = true;
      this.username = '';
      this.password = '';
    }
  });
}

  
  isLoggedIn(): boolean{
    return !this.loginservice.isUserLoggedIn(); //initially false
  }

}
