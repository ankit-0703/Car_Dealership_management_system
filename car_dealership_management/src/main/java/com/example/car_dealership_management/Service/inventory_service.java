package com.example.car_dealership_management.Service;

import com.example.car_dealership_management.model.inventory_details;
import com.example.car_dealership_management.repo.inventory_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class inventory_service {

    @Autowired
    private inventory_repo inventoryRepo;

    public List<inventory_details> getAllInventory(){
        return inventoryRepo.findAll();
    }

    public void addInventory(inventory_details details) {
        inventoryRepo.save(details);
    }

    public void update(inventory_details detials) {
        inventoryRepo.save(detials);
    }


    public void deleteById(int id) {
        inventoryRepo.deleteById(id);
    }
}
