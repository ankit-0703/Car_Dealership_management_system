package com.example.car_dealership_management.controller;

import com.example.car_dealership_management.Service.Car_Service;
import com.example.car_dealership_management.model.Car_comp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class dealController {
    @Autowired
    private Car_Service service;

    @GetMapping("cars")
    public List<Car_comp> getAllCars(){
        return service.getAllcars();
    }

    @PostMapping("cars")
    public String addCar(@RequestBody Car_comp car){
        service.addCars(car);
        return "The value has been stored successfully";
    }
}
