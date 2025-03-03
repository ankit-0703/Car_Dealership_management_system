package com.example.car_dealership_management.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class order_table {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int order_id;
    private int cust_id;
    private int car_model_id;
    private Date date_of_order;

}
