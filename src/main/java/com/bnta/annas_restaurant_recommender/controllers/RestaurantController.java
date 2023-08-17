package com.bnta.annas_restaurant_recommender.controllers;

import com.bnta.annas_restaurant_recommender.models.*;
import com.bnta.annas_restaurant_recommender.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    //    INDEX
    @GetMapping
    public ResponseEntity<List<Restaurant>> getRestaurants(@RequestParam(required = false, name = "borough") String borough, @RequestParam(required = false, name = "cuisine") String cuisines) {

        FilterDTO filterDTO = new FilterDTO();
        filterDTO.setBoroughFilter(borough);
        filterDTO.setCuisineFilter(cuisines);


        return new ResponseEntity<>(restaurantService.getRestaurantsByFilters(filterDTO),HttpStatus.OK);





        // /restaurants?borough
        // filters from request parameters
        // check if request parameters exist
        // if exists, return corresponding list of restaurants
        // if borough matches, return restaurants
        // else return error
        // if request parameters does not exist return all restaurants

//        TODO logic with DTO if parameter exists change filterDTO to true or false, need to refactor in the end adding logic to RestaurantService
//        Change which ever DTO property has been entered as a request parameter
//        Checks borough



//        boolean invalidUrl = false;
//        if (borough != null) {
//            Borough foundBorough = Borough.findByName(borough);
//            if (foundBorough != null) {
//                filterDTO.setBoroughFilter(foundBorough);
////                        new ResponseEntity<>(restaurantService.getRestaurantsByBorough(foundBorough), HttpStatus.OK);
//            } else {
//                invalidUrl = true;
//            }
//        }
////        Checks cuisine
//        if (cuisines != null) {
//            for (String cuisine : cuisines){
//                Cuisine foundCuisine = Cuisine.findByName(cuisine);
//                List<Cuisine> foundCuisines = new ArrayList<>();
//                if (foundCuisine != null) {
//                    foundCuisines.add(foundCuisine);
//                    filterDTO.setCuisineFilter(foundCuisines);
//                    return new ResponseEntity<>(restaurantService.getRestaurantByCuisine(cuisines),HttpStatus.OK);
//                } else {
//                    invalidUrl = true;
//                }
//            }
//
//// Still need to add response entity for cuisine filter
//        }
//
//        if (invalidUrl){
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//        else {
//            return new ResponseEntity<>(restaurantService.findAllRestaurants(), HttpStatus.OK);
//        }


    }

    //    SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Restaurant>> getRestaurantById(@PathVariable Long id) {
        Optional<Restaurant> foundRestaurant = restaurantService.findRestaurant(id);
        if (foundRestaurant.isPresent()) {
            return new ResponseEntity<>(restaurantService.findRestaurant(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //    CREATE
    @PostMapping
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        Restaurant newRestaurant = restaurantService.saveRestaurant(restaurantDTO);
        return new ResponseEntity<>(newRestaurant, HttpStatus.CREATED);
    }

    //    UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody RestaurantDTO restaurantDTO, @PathVariable Long id) {
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(restaurantDTO, id);
        return new ResponseEntity<>(updatedRestaurant, HttpStatus.OK);
    }

//    DELETE

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteRestaurant(@PathVariable Long id) {
        Optional<Restaurant> foundRestaurant = restaurantService.findRestaurant(id);
        if (foundRestaurant.isPresent()) {
            restaurantService.deleteRestaurant(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
}
