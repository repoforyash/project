import { Component, OnInit,Output,EventEmitter } from '@angular/core';
import { CustomerMaster } from '../CustomerMaster';
import { Router } from '@angular/router';
import { CustomerService } from '../customer-service';
import { NgForm } from '@angular/forms'; 

@Component({
  selector: 'app-view-customer-by-id',
  templateUrl: './view-customer-by-id.component.html',
  styleUrls: ['./view-customer-by-id.component.css']
})
export class ViewCustomerByIdComponent implements OnInit{

  customer: CustomerMaster = new CustomerMaster();
  customers: CustomerMaster[] | undefined;
  submitted = false;
  noRecordFound=false;
  custId:string | undefined; 

  constructor(private router: Router, private customerService: CustomerService) {
  }
  search() {
    this.customerService.getCustomerById(this.customer)
    .subscribe( (data: any) => {
      this.customers = data;
      console.log(this.customers);
    });
    // if(this.customers.length==0){
    //   console.log("in if");
    //   this.noRecordFound=true;
    // }
  }
  ngOnInit() {
  }


  onSubmit(form:NgForm ) {
    console.log(JSON.stringify(this.customer.custId));
    this.submitted = true;
    this.search();

   }


}
