package com.example.car_dealership_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private custController custControllers;

    @GetMapping("/customers")
    public String customers(Model model){
        model.addAttribute("customers",custControllers.getAllCustomer());
        return "customers";
    }
}
