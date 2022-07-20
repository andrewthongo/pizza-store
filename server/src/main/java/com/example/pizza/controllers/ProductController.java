package com.example.pizza.controllers;

import com.example.pizza.entities.Pizza;
import com.example.pizza.entities.ResponseObject;
import com.example.pizza.repositories.PizzaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private PizzaRepository repository;

    @GetMapping("")
    List<Pizza> getAllPizza() {
        LOGGER.info("GET Pizza list");
        return repository.findAll();
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> addPizza(@RequestBody Pizza newPizza) {
        List<Pizza> result = repository.getAllByName(newPizza.getName().trim());
        if(result.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("fail", "Pizza name is already used", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "Insert new Pizza successfully", repository.save(newPizza))
        );
    }
}
