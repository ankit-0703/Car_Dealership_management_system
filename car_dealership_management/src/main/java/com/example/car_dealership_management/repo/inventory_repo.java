package com.example.car_dealership_management.repo;

import com.example.car_dealership_management.model.inventory_details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface inventory_repo extends JpaRepository<inventory_details,Integer> {
}
