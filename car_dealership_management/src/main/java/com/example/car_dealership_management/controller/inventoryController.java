package com.example.car_dealership_management.controller;

import com.example.car_dealership_management.Service.inventory_service;
import com.example.car_dealership_management.model.inventory_details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class inventoryController {

    @Autowired
    private inventory_service inventoryService;

    @GetMapping("inventory")
    public List<inventory_details> inventory_details(){
        List<inventory_details> inventory=inventoryService.getAllInventory();
        return inventory;
    }

    @PostMapping("inventory")
    public String addInventory(@RequestBody inventory_details details){
        inventoryService.addInventory(details);
        return "Added";
    }

    @PutMapping("inventory")
    public String updateInventory(@RequestBody inventory_details detials){
        inventoryService.update(detials);
        return "Updated";
    }
    @DeleteMapping("inventory/{inventory_id}")
    public String DeleteInven(@PathVariable int inventory_id){
        inventoryService.deleteById(inventory_id);
        return "Deleted";
    }
}
