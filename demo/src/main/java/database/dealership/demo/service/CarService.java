package database.dealership.demo.service;

import database.dealership.demo.entity.Car;
import database.dealership.demo.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public Car saveCar(Car car){
        return carRepository.save(car);
    }

}
