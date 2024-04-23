import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { NewLoanApplicationComponent } from './new-loan-application/new-loan-application.component';
import { UpdateLoanApplicationComponent } from './update-loan-application/update-loan-application.component';
// import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
//import { AuthGuardUserService } from './service/auth-guarduser.service';
import { HomeComponent } from './home/home.component';

const routes: Routes = [

  {path: 'customers/new', component: AddCustomerComponent},
  {path: 'customers/{custId}/update', component: UpdateCustomerComponent},
  {path: 'customers/loan/new', component: NewLoanApplicationComponent},
  {path: 'customers/loan/{loanAppId}/update', component: UpdateLoanApplicationComponent},
  {path: 'logout', component: LogoutComponent },
  {path: 'home', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
