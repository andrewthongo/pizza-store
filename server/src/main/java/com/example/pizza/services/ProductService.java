package com.example.pizza.services;

import com.example.pizza.dto.DrinkDto;
import com.example.pizza.dto.PizzaDto;
import com.example.pizza.entities.Drink;
import com.example.pizza.entities.Pizza;
import com.example.pizza.repositories.DrinkRepository;
import com.example.pizza.repositories.PizzaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private PizzaRepository pizzaRepository;

    private DrinkRepository drinkRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public ProductService(PizzaRepository pizzaRepository, DrinkRepository drinkRepository) {
        this.pizzaRepository = pizzaRepository;
        this.drinkRepository = drinkRepository;
    }

    public List<Pizza> getAllPizza() {
        return pizzaRepository.findAll();
    }

    public Optional<PizzaDto> addPizza(PizzaDto pizzaDto) {
        Pizza result = toEntity(pizzaDto);
        result = pizzaRepository.save(result);
        PizzaDto newPizza = toModel(result);
        return Optional.of(newPizza);
    }

    public List<Drink> getAllDrink() {
        return drinkRepository.findAll();
    }

    public Optional<DrinkDto> addDrink(DrinkDto drinkDto) {
        Drink result = toEntity(drinkDto);
        result = drinkRepository.save(result);
        DrinkDto newDrink = toModel(result);
        return Optional.of(newDrink);
    }

    private Drink toEntity(DrinkDto request) {
        Drink requestEntity = modelMapper.map(request, Drink.class);
        return requestEntity;
    }

    private DrinkDto toModel(Drink requestEntity) {
        DrinkDto request = modelMapper.map(requestEntity, DrinkDto.class);
        return request;
    }

    private Pizza toEntity(PizzaDto request) {
        Pizza requestEntity = modelMapper.map(request, Pizza.class);
        return requestEntity;
    }

    private PizzaDto toModel(Pizza requestEntity) {
        PizzaDto request = modelMapper.map(requestEntity, PizzaDto.class);
        return request;
    }

}
