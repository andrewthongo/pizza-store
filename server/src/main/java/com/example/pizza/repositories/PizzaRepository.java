package com.example.pizza.repositories;

import com.example.pizza.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> { //<Entity type, Primary key type>
    List<Pizza> getAllByName(String name);
}
