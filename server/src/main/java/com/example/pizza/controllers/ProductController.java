package com.example.pizza.controllers;

import com.example.pizza.dto.DrinkDto;
import com.example.pizza.dto.PizzaDto;
import com.example.pizza.entities.Drink;
import com.example.pizza.entities.Pizza;
import com.example.pizza.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/pizza")
    List<Pizza> getAllPizza() {
        return productService.getAllPizza();
    }

    @PostMapping("/pizza/insert")
    ResponseEntity<PizzaDto> addPizza(@RequestBody PizzaDto pizzaDto) {
        Optional<PizzaDto> result = productService.addPizza(pizzaDto);
        return new ResponseEntity<>(result.get(), HttpStatus.CREATED);
    }

    @GetMapping("/drink")
    List<Drink> getAllDrink() {
        return productService.getAllDrink();
    }

    @PostMapping("/drink/insert")
    ResponseEntity<DrinkDto> addDrink(@RequestBody DrinkDto drinkDto) {
        Optional<DrinkDto> result = productService.addDrink(drinkDto);
        return new ResponseEntity<>(result.get(), HttpStatus.CREATED);
    }
}
