package database.dealership.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.annotation.meta.When;
import java.util.ArrayList;
import java.util.List;

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


    @Autowired
    @InjectMocks
    private CarController carController;

//    This annotation is used to indicate that the annotated method should be executed before each @Test method in the current class.
//        Replacement for @Before annotation from junit 4
    @BeforeEach
    public void controllerSetup() {
        carController.setCarService(carService);
    }

    @RequestMapping
    @Test
    public void addCarTest() throws  Exception {
        String make = "Toyota";
        String model = "Camry";
        int year = 2017;
        String vin = "67900";
        String color = "Pink";

        Car expectedCar = new Car(make, model, year, vin, color);
        expectedCar.setId(new Long(1L));
//
//      String carJson = "{\"id\":1,\"make\":\"" + make + "\",\"model\":\"" + model + "\",\"year\":" + year + "\",\"vin\":" + vin + "\",\"color\":" + vin + "\"}";
        ObjectMapper mapper = new ObjectMapper();
        String carJson = mapper.writeValueAsString(expectedCar);

        System.out.println(carJson);
        MvcResult res = this.mockMvc.perform(post("/dealership")
                .contentType(MediaType.APPLICATION_JSON)
                .content(carJson)
                .characterEncoding("utf-8"))
                .andExpect(status().isCreated())
                .andReturn();
                System.out.println(res);
        Mockito.verify(carService).saveCar(expectedCar);
    }

    @RequestMapping
    @Test
    public void listCarsTest() throws Exception {
        Car a = new Car("Honda", "Civic", 2022, "123456", "Blue");
        Car b = new Car("Porche", "911", 2019, "76543", "Black");
        Car c = new Car("Toyota", "Camry", 2021, "463789", "Red");

        List<Car> cars = new ArrayList<>();
        cars.add(a);
        cars.add(b);
        cars.add(c);

        System.out.println(cars);

        MvcResult res = this.mockMvc.perform(get("/dealership"))
                .andExpectAll(status().isOk())
                .andReturn();
        System.out.println(res);
        Mockito.verify(carService).getCars();

    }
    @RequestMapping(value = "/dealership/{id}", method = RequestMethod.DELETE)
    @Test
    public void delete() throws Exception {
        Car one = new Car("Porche", "911", 2019, "76543", "Black");
        Car two = new Car("Toyota", "Camry", 2021, "463789", "Red");

        one.setId(new Long(1L));
        two.setId(new Long(2L));

        List<Car> cars =new ArrayList<>();
        cars.add(one);
        cars.add(two);
        System.out.println(cars);

        carService.deleteCar(one.getId());
        ResultActions res = this.mockMvc.perform(MockMvcRequestBuilders.delete("/dealership/1L")
                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
        System.out.println(res);
        Mockito.verify(carService).deleteCar(one.getId());

    }


//
}
