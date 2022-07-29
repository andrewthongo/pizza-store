package com.example.pizza.repositories;

import com.example.pizza.entities.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
    List<Drink> getAllByName(String name);
}
