import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer-service';
import { LoanApplication } from '../LoanApplication';
import { Router } from '@angular/router';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-update-loan-application',
  templateUrl: './update-loan-application.component.html',
  styleUrls: ['./update-loan-application.component.css']
})
export class UpdateLoanApplicationComponent implements OnInit{

  loanApplication: LoanApplication = new LoanApplication();
  submitted = false;
  loanAppId!: string;
  isEditable = false;
  isStatusEditable = false;

  constructor(private router: Router, private customerService: CustomerService){

    this.loanApplication.loanAppId=this.customerService.getLoanAppId(); 
    this.customerService.getLoanApplicationById(this.loanApplication)
      .subscribe( data=> {
      this.loanApplication = data;
      console.log(data);

      this.loanApplication.loanAppId = data['loanAppId'];
      this.loanApplication.custId = data['custId'];
      this.loanApplication.loanAmt = data['loanAmt'];
      this.loanApplication.noOfYears = data['noOfYears'];
      this.loanApplication.purpose = data['purpose'];
      this.loanApplication.appStatus = data['appStatus'];
      this.loanApplication.typeOfLoan = data['typeOfLoan'];
      this.loanApplication.loanAppDate = data['loanAppDate'];
      this.loanApplication.status = data['status'];

  });
}

ngOnInit(): void{

}

viewLoanApplication(): void {
  if (this.loanApplication.loanAppId) {
    this.customerService.getLoanApplicationById(this.loanApplication)
      .subscribe((data) => {         
        this.loanApplication = data;
        this.checkEditableFields();
      });
  }
}

checkEditableFields(): void{
  if(this.loanApplication.appStatus === 'NewLoan'){
    this.isEditable = true;
    this.isStatusEditable=false;
  }else if(this.loanApplication.appStatus ==='Approved') {
      this.isEditable = false;
      this.isStatusEditable=true;
  }else{
    this.isEditable = false;
    this.isStatusEditable=false;
  }
}



updateLoanApplication(): void {
  this.submitted = true;
  this.customerService.updateLoanApplication(this.loanApplication)
    .subscribe(() => {

      console.log("Loan Application Updated");
      this.resetForm();
      
    });
}

resetForm(): void {
  this.loanApplication = new LoanApplication();
  
}

onSubmit() {
  this.submitted = true;
  this.updateLoanApplication();
}

// convertToDate(date: Date): string{
//   const year=date.getFullYear();
//   const month = (date.getMonth()+1).toString().padStart(2,'0');
//   const day = date.getDate().toString().padStart(2, '0');
//   // const [datePart, timePart] = dateString.split(' ');
//   // const [year, month, day] = datePart.split('-');
//   return  `${day}-${month}-${year}`;
  
// }

}
