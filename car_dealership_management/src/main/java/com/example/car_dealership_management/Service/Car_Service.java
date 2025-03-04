package com.example.car_dealership_management.Service;

import com.example.car_dealership_management.model.Car_comp;
import com.example.car_dealership_management.repo.Car_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Car_Service {

    @Autowired
    private Car_repo carRepo;


    public List<Car_comp> getAllcars() {
        return carRepo.findAll();
    }


    public void addCars(Car_comp car) {
        carRepo.save(car);
    }

    public void deleteCar(int carId) {
        carRepo.deleteById(carId);
    }

    public void update(Car_comp car){
        carRepo.save(car);
    }

    public Car_comp getCarById(int carModelId) {
        return carRepo.findById(carModelId).orElse(new Car_comp());
    }
}
