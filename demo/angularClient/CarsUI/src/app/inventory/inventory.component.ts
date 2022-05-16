import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { CarService } from 'src/service/car.service';
import { Car } from '../car';


@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent implements OnInit {

  cars: any;

 // constructor(private carService: CarService) {
    //this.carService.findAll().subscribe(data => {
     // this.cars = data
   // })
  //}
    constructor(private http: HttpClient) {

  }



  ngOnInit(): void {
  let repsonse = this.http.get("http://localhost:4200/");
  repsonse.subscribe((data) => this.cars=repsonse)

  }

}
