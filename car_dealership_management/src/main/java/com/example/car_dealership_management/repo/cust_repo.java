package com.example.car_dealership_management.repo;


import com.example.car_dealership_management.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cust_repo extends JpaRepository<Customer,Integer> {


    }
