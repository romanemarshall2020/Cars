package database.dealership.demo.controller;

import database.dealership.demo.entity.Car;
import database.dealership.demo.repo.CarRepository;
import database.dealership.demo.service.CarService;
import org.springframework.http.ResponseEntity;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    private CarService carService;

    private CarRepository carRepository;

    @GetMapping("/dealership")
    public List<Car> getCars() {
        return carService.getCars();
    }

    @PostMapping("/dealership")
    public ResponseEntity<Car> addCar(@RequestBody Car sedan) {
        carRepository.save(sedan);
        return new ResponseEntity<> (sedan, HttpStatus.CREATED);
    }


public void setCarRepository(CarRepository carRepository) {this.carRepository = carRepository;}
}
