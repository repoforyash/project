import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerMaster } from '../CustomerMaster';
import { CustomerService } from '../customer-service';


@Component({
  selector: 'app-view-customer',
  templateUrl: './view-customer.component.html',
  styleUrls: ['./view-customer.component.css']
})
export class ViewCustomerComponent implements OnInit {

  customers: CustomerMaster[] | undefined;

  constructor(private router: Router, private customerService: CustomerService) {
    this.customerService.getCustomers()
    .subscribe( data => {
      this.customers = data;
    });
 
    
  }

  ngOnInit() {
   

  };
  public selectedCustId:any;
  
  public highlightRow(customer: { custId: any; }) {
    this.selectedCustId = customer.custId;
  }


}
