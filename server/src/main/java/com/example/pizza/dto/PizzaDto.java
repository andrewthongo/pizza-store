package com.example.pizza.dto;

import lombok.Data;

@Data
public class PizzaDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
}
