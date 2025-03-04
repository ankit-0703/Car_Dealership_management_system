package com.example.car_dealership_management.controller;

import com.example.car_dealership_management.Service.Cust_service;
import com.example.car_dealership_management.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class custController {

    @Autowired
    private Cust_service custService;

    @GetMapping("customer")
    public List<Customer> getAllCustomer(){
        return custService.getAllcust();
    }
    @PostMapping("customer")
    public void addCustomer(@RequestBody Customer customer){
        custService.addCustomer(customer);

    }
    @PutMapping("customer")
    public String updateCust(@RequestBody Customer customer){
        custService.update(customer);
        return "Value is been updated";
    }
    @DeleteMapping("customer/{custId}")
    public String deleteCust(@PathVariable int custId){
        custService.delete(custId);
        return "Deleted";
    }
}
