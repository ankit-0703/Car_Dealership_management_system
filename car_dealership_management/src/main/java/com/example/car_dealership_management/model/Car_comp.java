package com.example.car_dealership_management.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car_comp{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int car_model_id;

    private String model_Name;
    private String car_desc;
    private Date launch_date;
}
