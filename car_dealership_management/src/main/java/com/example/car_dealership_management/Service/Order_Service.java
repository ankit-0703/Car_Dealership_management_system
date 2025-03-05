package com.example.car_dealership_management.Service;

import com.example.car_dealership_management.model.order_details;
import com.example.car_dealership_management.repo.order_car_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Order_Service {
    @Autowired
    private order_car_repo orderCarRepo;

    public List<order_details> getAllOrders(){
        return orderCarRepo.findAll();
    }

    public void addOrder(order_details order) {
        orderCarRepo.save(order);
    }

    public void DeleteById(int orderId) {
        orderCarRepo.deleteById(orderId);
    }

    public void update(order_details order) {
        orderCarRepo.save(order);
    }

    public Optional<order_details> getOrderById(int id) {
        return Optional.of(orderCarRepo.getById(id));
    }
}
