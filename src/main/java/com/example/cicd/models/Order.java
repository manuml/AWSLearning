package com.example.cicd.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer OrderId;
    private String paymentId;
    private String[] items;
    private Double totalCost;
    private String Date;
}
