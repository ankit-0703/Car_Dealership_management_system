package com.example.car_dealership_management.Service;

import com.example.car_dealership_management.model.Customer;
import com.example.car_dealership_management.repo.cust_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Cust_service {

    @Autowired
    private cust_repo custRepo;


    public List<Customer> getAllcust() {
        return custRepo.findAll();
    }

    public void addCustomer(Customer customer) {
        custRepo.save(customer);
        System.out.println("Save successfully");

    }
}
