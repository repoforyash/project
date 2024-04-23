// import { Injectable } from '@angular/core';
// import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
// import { AuthenticationService } from './authentication.service';

// @Injectable({
//   providedIn: 'root'
// })
// export class AuthGuardAdminService implements CanActivate {

//   constructor(private router: Router,
//     private authService: AuthenticationService) { }

//   canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
//     if (this.authService.isUserLoggedIn() && this.authService.isUserAdmin()){
//       return true;
//     }else if(this.authService.isUserLoggedIn() && !this.authService.isUserAdmin())
//       {
//         alert("Not authorized");
//         console.log("inside authadmin")
//         return false;
//       }
//     else{
//         this.router.navigate(['home']);
//         console.log("inside authadmin")
//         return false;
//     }

//   }


// }