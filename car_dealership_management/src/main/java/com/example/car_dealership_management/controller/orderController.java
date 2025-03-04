package com.example.car_dealership_management.controller;

import com.example.car_dealership_management.Service.Order_Service;
import com.example.car_dealership_management.model.order_details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class orderController {
    @Autowired
    private Order_Service orderService;

    @GetMapping("orders")
    public List<order_details> getAllOrders(){
        return orderService.getAllOrders();
    }
    @PostMapping("orders")
    public String addOrder(@RequestBody order_details order){
        orderService.addOrder(order);
        return "Order added";
    }

    @DeleteMapping("orders/{order_id}")
    public String UpdateOrder(@PathVariable int order_id){
        orderService.DeleteById(order_id);
        return "value is been removed";
    }

    @PutMapping("orders")
    public String UpdateVal(@RequestBody order_details order){
        orderService.update(order);
        return "Value updated";
    }
}
