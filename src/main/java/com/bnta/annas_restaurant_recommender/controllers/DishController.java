package com.bnta.annas_restaurant_recommender.controllers;

import com.bnta.annas_restaurant_recommender.models.Dish;
import com.bnta.annas_restaurant_recommender.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("dishes")
public class DishController {

    @Autowired
    DishService dishService;

    @GetMapping
    public ResponseEntity<List<Dish>> getAllDishes(){
        return new ResponseEntity<>(dishService.findAllDishes(), HttpStatus.OK);

    }




}
