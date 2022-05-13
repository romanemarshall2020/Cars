package database.dealership.demo;

import database.dealership.demo.controller.CarController;
import database.dealership.demo.entity.Car;
import database.dealership.demo.repo.CarRepository;
import database.dealership.demo.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
@CrossOrigin(origins = "http://localhost:8080/dealership")
public class CarsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CarService carService;


    @Mock
    private CarRepository carRepository;

    @Autowired
    @InjectMocks
    private CarController carController;

    @BeforeEach
    public void controllerSetup() {
        carController.setCarService(carService);
    }

    @RequestMapping
    @Test
    public void addCarTest() throws  Exception {
        String make = ("Toyota");
        String model = ("Camry");
        double year = (2017);

        Car expectedCar = new Car(make, model, year);
//
        String carJson = "{\"id\":1,\"make\":\"" + make + "\",\"model\":\"" + model + "\",\"year\":" + year + "}";

        System.out.println(carJson);
        MvcResult res = this.mockMvc.perform(post("/dealership")
                .contentType(MediaType.APPLICATION_JSON)
                .content(carJson)
                .characterEncoding("utf-8"))
                .andExpect(status().isCreated())
                .andReturn();
                System.out.println(res);
        Mockito.verify(carRepository).save(expectedCar);




    }

}
