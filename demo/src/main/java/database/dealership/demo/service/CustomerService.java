package database.dealership.demo.service;


import database.dealership.demo.entity.Customer;
import database.dealership.demo.repo.CarRepository;
import database.dealership.demo.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer saveCustomers(Customer customer){
        return customerRepository.save(customer);
    }


}
