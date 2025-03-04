package com.example.car_dealership_management.controller;

import com.example.car_dealership_management.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }
    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }
    @GetMapping("/carmodel")
    public String car_model(){
        return "carmodel";
    }
    @GetMapping("add-customer")
    public String add_customer(){
        return "add-customer";
    }

    @GetMapping("add-customer/new")
    public String addCustomer(Model model){
        Customer customer =new Customer();
        model.addAttribute("customers",customer);
        return "add-customer";
    }

    @PostMapping("add-customer")
    public String saveCustomer(@ModelAttribute("customers")Customer customer){
        custControllers.addCustomer(customer);
        return "customers";
    }


}
