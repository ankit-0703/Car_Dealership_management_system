package com.example.car_dealership_management.controller;

import com.example.car_dealership_management.Service.Car_Service;
import com.example.car_dealership_management.Service.Cust_service;
import com.example.car_dealership_management.Service.Order_Service;
import com.example.car_dealership_management.Service.inventory_service;
import com.example.car_dealership_management.model.Car_comp;
import com.example.car_dealership_management.model.Customer;
import com.example.car_dealership_management.model.order_details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.car_dealership_management.model.inventory_details;

import java.util.Optional;

@Component
@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private custController custControllers;
    @Autowired
    private Cust_service cust_service;

    @Autowired
    private carController carController;

    @Autowired
    private Car_Service carService;

    @Autowired
    private orderController orderController;
    @Autowired
    private Order_Service order_Service;

    @Autowired
    private inventoryController inventory_Controller;
    @Autowired
    private inventory_service inventoryService;


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

    @GetMapping("delete_cust/{id}")
    public String deleteCust(@PathVariable int id){
        custControllers.deleteCust(id);
        return "success";
    }


    @GetMapping("/carmodel")
    public String car_model(Model model){
        model.addAttribute("carModels", carController.getAllCars());
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
        carController.addCar(car);
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
        carController.updateVal(car);
        return "carmodel";
    }


    @GetMapping("delete_car/{id}")
    public String delCar(@PathVariable int id){
        carController.deleteCar(id);
        return "success";
    }


    @GetMapping("order_details")
    public String order_details(Model model){
        model.addAttribute("orders",orderController.getAllOrders());
        return "order_details";
    }

    @GetMapping("orders_add")
    public String add_orders(Model model){
        order_details order_s=new order_details();
        model.addAttribute("order_s",order_s);
        return "orders_add";
    }

    @PostMapping("orders_add")
    public String saveOrders(@ModelAttribute order_details order_s){
        orderController.addOrder(order_s);
        return "order_details";
    }


    @GetMapping("orders_update/{id}")
    public String update_orders(@PathVariable int id,Model model){
        Optional<order_details> orders_u=order_Service.getOrderById(id);
        if(orders_u.isPresent()){
            model.addAttribute("order_u",orders_u);
            return "orders_update";
        }else{
            return "order_details";
        }
    }


    @PostMapping("orders_update")
    public String saveUpdate(@ModelAttribute order_details order_u){
        orderController.UpdateVal(order_u);
        return "order_details";
    }

    @GetMapping("order_d/{id}")
    public String deleteOrder(@PathVariable int id){
        orderController.UpdateOrder(id);
        return "success";
    }

    @GetMapping("success")
    public String successful(){
        return "success";
    }


    @GetMapping("inventories")
    public String inventory(Model model){
        model.addAttribute("inventoring",inventory_Controller.getAll_inventory());
        return "inventories";
    }

    @GetMapping("inventory_add")
    public String addInventory(Model model){
        inventory_details detail=new inventory_details();
        model.addAttribute("addInventory",detail);
        return "inventory_add";
    }

    @PostMapping("inventory_add")
    public String saveInventory(@ModelAttribute inventory_details detail){
        inventory_Controller.addInventory(detail);
        return "success";
    }


    @GetMapping("inventory_update/{inventory_id}")
    public String updateInventory(@PathVariable int inventory_id,Model model){
        Optional<inventory_details> details=inventoryService.getInventoryById(inventory_id);
        if(details.isPresent()){
            model.addAttribute("inventoryUp",details);
            return "inventory_update";
        }else{
            return "inventories";
        }
    }

    @PostMapping("inventory_update")
    public String saveInvUpdate(@ModelAttribute inventory_details details){
        inventory_Controller.updateInventory(details);
        return "success";
    }

    @GetMapping("inven_delete/{id}")
    public String Delete_inventory(@PathVariable int id){
        inventory_Controller.DeleteInven(id);
        return "success";
    }
}
