package com.bnta.annas_restaurant_recommender.controllers;

import com.bnta.annas_restaurant_recommender.models.Cuisine;
import com.bnta.annas_restaurant_recommender.models.Dish;
import com.bnta.annas_restaurant_recommender.models.DishDTO;
import com.bnta.annas_restaurant_recommender.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("dishes")
public class DishController {

    @Autowired
    DishService dishService;

    //    INDEX
    @GetMapping
    public ResponseEntity<List<Dish>> getAllDishes() {
        return new ResponseEntity<>(dishService.findAllDishes(), HttpStatus.OK);
    }

    //    SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Dish>> getDishById(@PathVariable Long id) {
        Optional<Dish> foundDish = dishService.findDishById(id);

        if (foundDish.isPresent()) {
            return new ResponseEntity<>(foundDish, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    //    CREATE
    @PostMapping
    public ResponseEntity<Dish> addDish(@RequestBody DishDTO dishDTO) {
        Cuisine findCuisine = dishService.checkCuisineExists(dishDTO);
        if (findCuisine == null) {
            return new ResponseEntity<>(null, HttpStatus.UNPROCESSABLE_ENTITY);
        } else {
            return new ResponseEntity<>(dishService.saveDish(dishDTO), HttpStatus.CREATED);
        }
    }

    //    DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> removeDish(@PathVariable Long id) {
        Optional<Dish> foundDish = dishService.findDishById(id);
        if (foundDish.isPresent()) {
            dishService.removeDish(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

}
