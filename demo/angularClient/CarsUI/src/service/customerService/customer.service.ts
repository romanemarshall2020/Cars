import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

import { Customer } from 'src/app/models/customer/customer';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  CustURL: string = "http://localhost:8080/customer"

  constructor(private http: HttpClient) {
    this.findAll().subscribe
  }

  public findAll(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.CustURL);
  }
}
