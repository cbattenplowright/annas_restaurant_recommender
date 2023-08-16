package com.bnta.annas_restaurant_recommender.controllers;

import com.bnta.annas_restaurant_recommender.models.Restaurant;
import com.bnta.annas_restaurant_recommender.models.RestaurantDTO;
import com.bnta.annas_restaurant_recommender.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Optional<Restaurant>> getRestaurantById(@PathVariable Long id){
        Optional<Restaurant> foundRestaurant = restaurantService.findRestaurant(id);
        if (foundRestaurant.isPresent()){
            return new ResponseEntity<>(restaurantService.findRestaurant(id),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

//    CREATE
    @PostMapping
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody RestaurantDTO restaurantDTO){
        Restaurant newRestaurant = restaurantService.saveRestaurant(restaurantDTO);
        return new ResponseEntity<>(newRestaurant, HttpStatus.CREATED);
    }

//    UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody RestaurantDTO restaurantDTO, @PathVariable Long id){
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(restaurantDTO,id);
        return new ResponseEntity<>(updatedRestaurant,HttpStatus.OK);
    }

//    DELETE

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteRestaurant (@PathVariable Long id){
        Optional<Restaurant> foundRestaurant = restaurantService.findRestaurant(id);
        if (foundRestaurant.isPresent()){
            restaurantService.deleteRestaurant(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
}
