package com.example.car_dealership_management.repo;

import com.example.car_dealership_management.model.Car_comp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface Car_repo extends JpaRepository<Car_comp,Integer> {

}
