package com.cydeo.repository;

import com.cydeo.exception.PizzaNotFoundException;
import com.cydeo.model.Pizza;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PizzaRepository {

    private static final List<Pizza> pizzaList = new ArrayList<>();

    public void createPizza(Pizza pizzaToSave) {
        pizzaList.add(pizzaToSave);
    }

    public List<Pizza> readAll() {
        return pizzaList;
    }

    // TODO complete method
    public Pizza findPizzaById(UUID uuid) throws PizzaNotFoundException {
        return pizzaList.stream().filter(pizza -> pizza.getId().toString().equals(uuid.toString()))
                .findFirst().orElseThrow(() ->  new PizzaNotFoundException("Pizza not found"));
    }

}
