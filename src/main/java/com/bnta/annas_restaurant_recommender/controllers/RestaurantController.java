package com.bnta.annas_restaurant_recommender.controllers;

import com.bnta.annas_restaurant_recommender.models.Restaurant;
import com.bnta.annas_restaurant_recommender.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

//    INDEX
    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants(){
        return new ResponseEntity<>(restaurantService.findAllRestaurants(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable Long id){
        return new ResponseEntity<>(restaurantService.findRestaurant(id),HttpStatus.OK);
    }


}
