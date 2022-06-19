package database.dealership.demo.controller;

import database.dealership.demo.entity.Car;
import database.dealership.demo.repo.CarRepository;
import database.dealership.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CarController {
    @Autowired
    private CarService carService;


    @GetMapping("/dealership")
    public List<Car> getCars() {
        return carService.getCars();
    }

    @PostMapping("/dealership")
    public ResponseEntity<Car> addCar(@RequestBody Car sedan) {
       sedan = carService.saveCar(sedan);
        return new ResponseEntity<> (sedan, HttpStatus.CREATED);
    }


    public void setCarService(CarService carService) {this.carService = carService;}
}
