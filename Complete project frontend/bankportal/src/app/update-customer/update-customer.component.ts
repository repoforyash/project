import { Component, OnInit } from '@angular/core';
import { CustomerMaster } from '../CustomerMaster';
import { Router } from '@angular/router';
//import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CustomerService } from '../customer-service';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit{
 
  customer: CustomerMaster = new CustomerMaster();
  customers: CustomerMaster[] = [];
  submitted = false;
  noRecordFound=false;
  custId!: string;
  
  constructor(private router: Router, private customerService: CustomerService) { 

  this.customer.custId=this.customerService.getCustId();
  
  this.customerService.getCustomerById(this.customer)
    .subscribe( data=> {
    this.customer = data;
    console.log(data);

    this.customer.custId = data['custId'];
    this.customer.custFirstName = data['custFirstName'];
    this.customer.custLastName = data['custLastName'];
    this.customer.address = data['address'];
    this.customer.city = data['city'];
    this.customer.state = data['state'];
    this.customer.contactNo = data['contactNo'];
    this.customer.adharCard = data['adharCard'];
    this.customer.emailId = data['emailId'];
    this.customer.birthDate = data['birthDate'];
    this.customer.monthlySalary = data['monthlySalary'];




  });
}





  ngOnInit(): void{

  }
  viewCustomer(): void {
    if (this.customer.custId) {
      this.customerService.getCustomerById(this.customer)
        .subscribe((data) => {         
          this.customer = data;
        });
    }
  }

  updateCustomer(): void {
    this.submitted = true;
    this.customerService.updateCustomer(this.customer)
      .subscribe(() => {

        console.log("Customer information Updated");
        this.resetForm();
        
      });
  }

  resetForm(): void {
    this.customer = new CustomerMaster();
    
  }

  onSubmit() {
    this.submitted = true;
    this.updateCustomer();
  }

 

}


















   
    // viewCustomerDetails(): void{
    //   this.submitted = true;
    //   this.customerService.getCustomerById(this.customer.custId)
    //     .subscribe((data: CustomerMaster) =>{
    //       this.customer = data;
    //       console.log(data);
    //       this.viewCustomer = true;
    //     }, error => {
    //       console.log(error);
    //       this.viewCustomer = false;
        
    //     });
    // }
    
     
  