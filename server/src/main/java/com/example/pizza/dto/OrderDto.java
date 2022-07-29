package com.example.pizza.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    private Long orderId;
    private String orderedDateTime;
    private String name;
    private String deliveryAddress;
    private String phoneNumber;
    private List<PizzaDto> pizzas;
    private List<DrinkDto> drinks;
}
