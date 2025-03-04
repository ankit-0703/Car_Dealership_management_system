package com.example.car_dealership_management.controller;

import com.example.car_dealership_management.Service.Car_Service;
import com.example.car_dealership_management.model.Car_comp;
import jakarta.servlet.ServletConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class dealController {
    @Autowired
    private Car_Service service;
    @Autowired
    private ServletConfig servletConfig;

    @GetMapping("/cars")
    public List<Car_comp> getAllCars(){
        return service.getAllcars();
    }

    @PostMapping("/cars")
    public String addCar(@RequestBody Car_comp car){
        service.addCars(car);
        return "The value has been stored successfully";
    }

    @DeleteMapping("cars/{carId}")
    public String deleteCar(@PathVariable int carId){
        service.deleteCar(carId);
        return "Car Details removed";
    }

    @PutMapping("cars")
    public Car_comp updateVal(@RequestBody Car_comp car){
        service.update(car);
        return service.getCarById(car.getCar_model_id());
    }
}
