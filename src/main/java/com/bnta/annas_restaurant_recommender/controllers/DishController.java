package com.bnta.annas_restaurant_recommender.controllers;

import com.bnta.annas_restaurant_recommender.models.Dish;
import com.bnta.annas_restaurant_recommender.models.DishDTO;
import com.bnta.annas_restaurant_recommender.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("dishes")
public class DishController {

    @Autowired
    DishService dishService;

    @GetMapping
    public ResponseEntity<List<Dish>> getAllDishes(){
        return new ResponseEntity<>(dishService.findAllDishes(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Dish>> getDishById(@PathVariable Long id){
        Optional<Dish> foundDish = dishService.findDishById(id);

        if (foundDish.isPresent()){
            return new ResponseEntity<>(foundDish, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<Dish> addDish(@RequestBody DishDTO dishDTO){
        return new ResponseEntity<>(dishService.saveDish(dishDTO), HttpStatus.CREATED);
    }

}
