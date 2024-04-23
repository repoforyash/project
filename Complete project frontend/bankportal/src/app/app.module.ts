import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import {CustomerService} from './customer-service';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { NavbarComponent } from './navbar/navbar.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatSnackBar, MatSnackBarModule} from '@angular/material/snack-bar';
import { NewLoanApplicationComponent } from './new-loan-application/new-loan-application.component';
import { UpdateLoanApplicationComponent } from './update-loan-application/update-loan-application.component';
// import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { HomeComponent } from './home/home.component';
import { RouterModule } from '@angular/router';
// import {RouterModule} from './app.component';


@NgModule({
  declarations: [
    AppComponent,
    AddCustomerComponent,    
    UpdateCustomerComponent,
    NavbarComponent,
    NewLoanApplicationComponent,
    UpdateLoanApplicationComponent,
    LogoutComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    RouterModule
  ],
  providers: [MatSnackBar, CustomerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
