package database.dealership.demo.service;

import database.dealership.demo.entity.Car;
import database.dealership.demo.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void deleteCar(Long id) { carRepository.deleteById(id); }


    public Optional<Car> getCarById(Long id) { return  carRepository.findById(id); }

}
