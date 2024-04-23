import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CustomerMaster } from './CustomerMaster';
import { Observable } from 'rxjs';
import { LoanApplication } from './LoanApplication';


// const httpOptions = {
//   headers: new HttpHeaders({ 'Content-Type': 'application/json' })
// };

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  custId!: string ;
  loanAppId!: string;
 

 private registerCustomerURL='http://localhost:8080/api/customers/new';
 private updateCustomerURL='http://localhost:8080/api/customers';
 private retrieveCustomerByIdURL='http://localhost:8080/api/customers';
 private addLoanApplicationURL='http://localhost:8080/api/customers/loan/new';
 private retrieveLoanApplicationByIdURL='http://localhost:8080/api/customers/loan';
 private updateLoanApplicationURL='http://localhost:8080/api/customers/loan';


constructor(private http:HttpClient) { }

  // getHeaders(){
  //   let username='admin'
  //   let password='password'

  //   let  basicString='Basic '+window.btoa(username + ':' + password)
  //   return basicString;
  // }

  public getCustomerById(customer: CustomerMaster): Observable<CustomerMaster>{ 
    this.custId = customer.custId;
    return this.http.get<CustomerMaster>(`${this.retrieveCustomerByIdURL}/${this.custId}`);
  }
  
  public registerCustomer(customer?:CustomerMaster) {
    return this.http.post<CustomerMaster>(this.registerCustomerURL, customer);
  }
  public updateCustomer(customer: CustomerMaster): Observable<CustomerMaster>{
    return this.http.put<CustomerMaster>(`${this.updateCustomerURL}/${customer.custId}/update`, customer);
  }

  public addLoanApplication(loanApplication?:LoanApplication) {
    return this.http.post<LoanApplication>(this.addLoanApplicationURL, loanApplication);
  }

  public getLoanApplicationById(loanApplication:LoanApplication): Observable<LoanApplication>{ 
    this.loanAppId = loanApplication.loanAppId;
    return this.http.get<LoanApplication>(`${this.retrieveLoanApplicationByIdURL}/${this.loanAppId}`);
  }

  public updateLoanApplication(loanApplication:LoanApplication): Observable<LoanApplication>{
    return this.http.put<LoanApplication>(`${this.updateLoanApplicationURL}/${loanApplication.loanAppId}/update`, loanApplication);
  }

  public getCustId(){
    return this.custId;
  }

  public getLoanAppId(){
    return this.loanAppId;
  }

  
}
