import { Component, OnInit } from '@angular/core';
import { CustomerMaster } from '../CustomerMaster';
import { CustomerService } from '../customer-service';
import {FormGroup,FormControl,Validators} from '@angular/forms';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {

  formData!: FormGroup;
  customer: CustomerMaster = new CustomerMaster();
  submitted = false;
  text='Customer Form page';

  constructor(private customerService: CustomerService) {}
  ngOnInit(): void {

    this.formData=new FormGroup(
      {
       custFirstName: new FormControl("",Validators.compose(
         [
           Validators.required,
           Validators.pattern('[a-zA-Z]*')
         ]
       )),
       custLastName: new FormControl("",Validators.compose(
        [
          Validators.required,
          Validators.minLength(3),
          Validators.pattern('^[a-zA-Z]+$')      
        ]
      )), 
      contactNo: new FormControl("",Validators.compose(
        [
          Validators.required,
          Validators.pattern('^[0-9]{10}$')    
        ]
      )), 
      emailId: new FormControl("",Validators.compose(
        [
          Validators.required,
          Validators.pattern('.*@cognizant\.com$')      
        ]
      )),
      adharCard: new FormControl("",Validators.compose(
        [
          Validators.required      
        ]
      )),
      address: new FormControl("",Validators.compose(
        [
          Validators.required      
        ]
      )),
      city: new FormControl("",Validators.compose(
        [
          Validators.required      
        ]
      )),
      state: new FormControl("",Validators.compose(
        [
          Validators.required      
        ]
      )),
      monthlySalary: new FormControl("",Validators.compose(
        [
          Validators.required      
        ]
      )),
      birthDate: new FormControl("",Validators.compose(
        [
          Validators.required      
        ]
      )),
      loanType: new FormControl("",Validators.compose(
        [
          Validators.required      
        ]
      ))
      }
      );

  }

  newIntern(): void{
    this.submitted = false;
    this.customer = new CustomerMaster();
  }

  registerCustomer() {
    this.customerService.registerCustomer(this.customer).subscribe(data => console.log(data), error => console.log(error));
    this.customer = new CustomerMaster();
  }

  onSubmit(data: any){
    this.submitted = true;

    this.customer.custFirstName=data.custFirstName;
    this.customer.custLastName=data.custFirstName;
    this.customer.address = data.address;
    this.customer.city = data.city;
    this.customer.state = data.state;
    this.customer.contactNo = data.contactNo;
    this.customer.adharCard = data.adharCard;
    this.customer.emailId = data.emailId;
    this.customer.birthDate = data.birthDate;
    this.customer.monthlySalary = data.monthlySalary;
    
    if(this.formData.valid){
      this.customer = this.formData.value;
      this.registerCustomer();
    }
   
  }

  get custFirstName(): FormControl{
    return this.formData.get('custFirstName') as FormControl;
  }
  get custLastName(): FormControl{
    return this.formData.get('custLastName') as FormControl;
  }
  get address(): FormControl{
    return this.formData.get('address') as FormControl;
  }
  get city():FormControl{
    return this.formData.get('city') as FormControl;
  }
  get state():FormControl{
    return this.formData.get('state') as FormControl;
  }
  get contactNo():FormControl{
    return this.formData.get('contactNo') as FormControl;
  }
  get adharCard():FormControl{
    return this.formData.get('adharCard') as FormControl;
  }
  get emailId():FormControl{
    return this.formData.get('emailId') as FormControl;
  }
  get birthDate():FormControl{
    return this.formData.get('birthDate') as FormControl;
  }
  get monthlySalary():FormControl{
    return this.formData.get('monthlySalary') as FormControl;
  }
  get loanType():FormControl{
    return this.formData.get('monthlySalary') as FormControl;
  }

}
