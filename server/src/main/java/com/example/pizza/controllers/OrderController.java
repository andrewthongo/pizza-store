package com.example.pizza.controllers;

import com.example.pizza.dto.OrderDto;
import com.example.pizza.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/orders")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("")
    ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        Optional<OrderDto> result = orderService.createOrder(orderDto);
        return new ResponseEntity<>(result.get(), HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    ResponseEntity<OrderDto> getOrder(@PathVariable Long orderId) {
        Optional<OrderDto> result = orderService.getOrderById(orderId);
        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        } else {
            throw new NoSuchElementException("No order with id:  " + orderId + " found");
        }
    }
}
