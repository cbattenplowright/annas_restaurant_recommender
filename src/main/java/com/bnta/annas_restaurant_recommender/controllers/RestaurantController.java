package com.bnta.annas_restaurant_recommender.controllers;

import com.bnta.annas_restaurant_recommender.models.Restaurant;
import com.bnta.annas_restaurant_recommender.models.RestaurantDTO;
import com.bnta.annas_restaurant_recommender.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    CREATE
    @PostMapping
    public ResponseEntity <List<Restaurant>> addRestaurant(@RequestBody RestaurantDTO restaurantDTO){
        restaurantService.saveRestaurant(restaurantDTO);
        return new ResponseEntity<>(restaurantService.findAllRestaurants(), HttpStatus.OK);
    }

//    UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody RestaurantDTO restaurantDTO, @PathVariable Long id){
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(restaurantDTO,id);
        return new ResponseEntity<>(updatedRestaurant,HttpStatus.OK);
    }
    


}
