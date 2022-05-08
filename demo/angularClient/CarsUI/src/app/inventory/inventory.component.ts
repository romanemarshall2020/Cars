import { Component, OnInit } from '@angular/core';
import { CarService } from 'src/service/car.service';
import { Car } from '../car';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent implements OnInit {

  cars: Car[] | undefined

  constructor(private carService: CarService) {
    this.carService.findAll().subscribe(data => {
      this.cars = data
    })
  }



  ngOnInit(): void {

  }

}
