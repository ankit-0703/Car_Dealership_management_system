package com.example.car_dealership_management.repo;

import com.example.car_dealership_management.model.order_details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface order_car_repo extends JpaRepository<order_details,Integer> {

}
