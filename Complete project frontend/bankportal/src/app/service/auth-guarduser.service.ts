// import { Injectable } from '@angular/core';
// import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
// import { AuthenticationService } from './authentication.service';

// @Injectable({
//   providedIn: 'root'
// })
// export class AuthGuardUserService implements CanActivate {

//   constructor(private router: Router,
//     private authService: AuthenticationService) { }

//   canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
//     if (this.authService.isUserLoggedIn() &&  this.authService.isUserNotAdmin())
//     {
//       return true;
//       console.log("inside authuser")
//     }
//     this.router.navigate(['home']);
//     console.log("inside authuser")
//     return false;

//   }


// }