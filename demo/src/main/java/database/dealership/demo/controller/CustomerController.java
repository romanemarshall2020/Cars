package database.dealership.demo.controller;

import database.dealership.demo.entity.Car;
import database.dealership.demo.entity.Customer;
import database.dealership.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import database.dealership.demo.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {
    private CustomerService customerService;


    @GetMapping("/customer")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer buyer) {
        buyer = customerService.saveCustomers(buyer);
        return new ResponseEntity<> (buyer, HttpStatus.CREATED);
    }


    public void setCustomerService(CustomerService customerService) {this.customerService = customerService;}
}
