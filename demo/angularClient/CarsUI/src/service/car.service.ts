import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

// imported sedan Object
import {Car} from "src/app/car";
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CarService {

  private carsURL: string;


  constructor(private http: HttpClient) {
    this.carsURL = "http://localhost:8080/dealership"
  }

  public findAll(): Observable<Car[]> {
    return this.http.get<Car[]>(this.carsURL);
  }

  // public findAll() {
  //   this.HttpClient.get<Car[]>(this.carsURL)

  // }
}
