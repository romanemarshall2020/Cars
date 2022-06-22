// import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { CarService } from 'src/service/carService/car.service';
import { Car } from 'src/app/models/car/car';


@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent implements OnInit {

  cars: Car[] | undefined

 constructor(private carService: CarService) {
  
  }




  ngOnInit(): void {
     this.carService.findAll().subscribe(data => {
      this.cars = data
    })
  }

}
