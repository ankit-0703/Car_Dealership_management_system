package com.example.car_dealership_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class inventory_details {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int inventory_id;
    private int order_id;
    private int car_model_id;
    private int units;
}
