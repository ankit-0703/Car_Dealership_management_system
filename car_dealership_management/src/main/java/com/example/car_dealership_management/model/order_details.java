package com.example.car_dealership_management.model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class order_details {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int order_id;

    private int cust_id;
    private int car_model_id;

    private int date_of_order;
}
