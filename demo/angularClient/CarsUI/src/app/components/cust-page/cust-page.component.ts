 import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/models/customer/customer';
import { CustomerService } from 'src/service/customerService/customer.service';




@Component({
  selector: 'app-cust-page',
  templateUrl: './cust-page.component.html',
  styleUrls: ['./cust-page.component.css']
})
export class CustPageComponent implements OnInit {

  customers: Customer[] | undefined
  constructor(private customerService: CustomerService) {

  }

  ngOnInit(): void {
    this.customerService.findAll().subscribe(data => {
      this.customers = data
    })
  }

}
