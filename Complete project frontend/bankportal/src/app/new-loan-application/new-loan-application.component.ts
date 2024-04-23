import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer-service';
import { LoanApplication } from '../LoanApplication';
import {FormGroup,FormControl,Validators} from '@angular/forms';

@Component({
  selector: 'app-new-loan-application',
  templateUrl: './new-loan-application.component.html',
  styleUrls: ['./new-loan-application.component.css']
})
export class NewLoanApplicationComponent implements OnInit{

  formData!: FormGroup;
  loanApplication: LoanApplication = new LoanApplication();
  submitted = false;

  constructor(private customerService: CustomerService) {}

  ngOnInit():void {

    this.formData=new FormGroup(
      {
        custId: new FormControl("",Validators.compose(
         [
           Validators.required,
           Validators.pattern('[0-9]*')
         ]
       )),
       loanAmt: new FormControl("",Validators.compose(
        [
          Validators.required      
        ]
      )), 
      noOfYears: new FormControl("",Validators.compose(
        [
          Validators.required   
        ]
      )), 
      purpose: new FormControl("",Validators.compose(
        [
          Validators.required      
        ]
      )),
      appStatus: new FormControl("",Validators.compose(
        [
          Validators.required      
        ]
      )),
      typeOfLoan: new FormControl("",Validators.compose(
        [
          Validators.required      
        ]
      )),
      loanAppDate: new FormControl("",Validators.compose(
        [
          Validators.required      
        ]
      )),
      status: new FormControl("",Validators.compose(
        [
          Validators.required      
        ]
      ))
      }
      );


  }

  newIntern(): void{
    this.submitted = false;
    this.loanApplication = new LoanApplication();
  }

  addLoanApplication(){
    this.customerService.addLoanApplication(this.loanApplication).subscribe();
    this.loanApplication = new LoanApplication();
  }
 
  onSubmit(data: any){
    this.submitted = true;

    this.loanApplication.custId=data.custId;
    this.loanApplication.loanAmt=data.loanAmt;
    this.loanApplication.noOfYears=data.noOfYears;
    this.loanApplication.purpose=data.purpose;
    this.loanApplication.appStatus=data.appStatus;
    this.loanApplication.typeOfLoan=data.typeOfLoan;
    this.loanApplication.loanAppDate=data.loanAppDate;
    this.loanApplication.status=data.status;

    if(this.formData.valid){
      this.loanApplication = this.formData.value;
      this.addLoanApplication();
  }

}

get custId(): FormControl{
  return this.formData.get('custId') as FormControl;
}
get loanAmt(): FormControl{
  return this.formData.get('loanAmt') as FormControl;
}
get noOfYears(): FormControl{
  return this.formData.get('noOfYears') as FormControl;
}
get purpose(): FormControl{
  return this.formData.get('purpose') as FormControl;
}
get appStatus(): FormControl{
  return this.formData.get('appStatus') as FormControl;
}
get typeOfLoan(): FormControl{
  return this.formData.get('typeOfLoan') as FormControl;
}
get loanAppDate(): FormControl{
  return this.formData.get('typeOfLoan') as FormControl;
}
get status(): FormControl{
  return this.formData.get('typeOfLoan') as FormControl;
}



}