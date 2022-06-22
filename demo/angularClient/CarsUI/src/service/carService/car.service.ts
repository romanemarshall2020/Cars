import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

// imported sedan Object
import { Car } from 'src/app/models/car/car';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CarService {

  carsURL: string = "http://localhost:8080/dealership";


  constructor(private http: HttpClient) {
    this.findAll().subscribe
  }

  public findAll(): Observable<Car[]> {
    return this.http.get<Car[]>(this.carsURL);
  }

  // public findAll() {
  //   this.HttpClient.get<Car[]>(this.carsURL)

  // }
}
