package database.dealership.demo.controller;

import database.dealership.demo.entity.Car;
import database.dealership.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CarController {
    @Autowired
    private CarService carService;


    @GetMapping("/dealership")
    public List<Car> getCars() {
        return carService.getCars();
    }

    @GetMapping("/dealership/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") Long id) {
        Optional<Car> foundCar = carService.getCarById(id);
        if (foundCar.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Car updatedCar = foundCar.get();
        return new ResponseEntity<Car>(updatedCar, HttpStatus.OK);
    }

    @DeleteMapping("/dealership/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable("id") Long id) { carService.deleteCar(id);}

    @PostMapping("/dealership")
    public ResponseEntity<Car> addCar(@RequestBody Car newCar) {
       newCar = carService.saveCar(newCar);

        return new ResponseEntity<> (newCar, HttpStatus.CREATED);
    }

    public void setCarService(CarService carService) {this.carService = carService;}
}
