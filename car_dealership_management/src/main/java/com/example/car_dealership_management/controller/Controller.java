package com.example.car_dealership_management.controller;

import com.example.car_dealership_management.Service.Car_Service;
import com.example.car_dealership_management.Service.Cust_service;
import com.example.car_dealership_management.model.Car_comp;
import com.example.car_dealership_management.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private custController custControllers;
    @Autowired
    private Cust_service cust_service;

    @Autowired
    private dealController dealController;

    @Autowired
    private Car_Service carService;

    @Autowired
    private orderController orderController;


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

    @GetMapping("/upcustomer")
    public String update(){
        return "upcustomer";
    }


    @GetMapping("upcustomer/{id}")
    public String updateCust(@PathVariable int id,Model model){
        Optional<Customer> cust=cust_service.getCustbyId(id);
        if( cust.isPresent()){
            Customer customer =cust.get();
            model.addAttribute("customer",customer);
            return "upcustomer";
        }else{
            return "customers";
        }
    }


    @PostMapping("upcustomer")
    public String updating(@ModelAttribute ("customer")Customer cust){
        custControllers.updateCust(cust);
        return "customers";
    }

    @GetMapping("/carmodel")
    public String car_model(Model model){
        model.addAttribute("carModels",dealController.getAllCars());
        return "carmodel";
    }

    @GetMapping("add-car")
    public String add_new_Car(Model model){
        Car_comp car=new Car_comp();
        model.addAttribute("carModel",car);
        return "add-car";
    }

    @PostMapping("add-car")
    public String saveCar(@ModelAttribute Car_comp car){
        dealController.addCar(car);
        return "carmodel";
    }


    @GetMapping("carupdate/{id}")
    public String updateCar(@PathVariable int id,Model model){
        Optional<Car_comp> car= Optional.ofNullable(carService.getCarById(id));
        if(car.isPresent()) {
            model.addAttribute("carModel", car);
            return "carupdate";
        }else{
            return "carmodel";
        }
    }


    @PostMapping("carupdate")
    public String updatings(@ModelAttribute("carModel") Car_comp car){
        dealController.updateVal(car);
        return "carmodel";
    }


    @GetMapping("order_details")
    public String order_details(Model model){
        model.addAttribute("orders",orderController.getAllOrders());
        return "order_details";
    }

}
