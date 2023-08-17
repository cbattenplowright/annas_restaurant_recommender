package com.bnta.annas_restaurant_recommender.services;

import com.bnta.annas_restaurant_recommender.models.*;
import com.bnta.annas_restaurant_recommender.repositories.DishRepository;
import com.bnta.annas_restaurant_recommender.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.ServiceUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    DishRepository dishRepository;

    public List<Restaurant> findAllRestaurants(){

        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> findRestaurant(Long id){

        return restaurantRepository.findById(id);
    }

    public Restaurant saveRestaurant (RestaurantDTO restaurantDTO){

        List<Dish> dishes = new ArrayList<>();

        for (Long dishId : restaurantDTO.getDishIds()){
            dishes.add(dishRepository.findById(dishId).get());
        }

        Restaurant restaurant = new Restaurant(
                restaurantDTO.getName(),
                restaurantDTO.getBorough(),
                restaurantDTO.getPriceRange(),
                restaurantDTO.getRating(),
                dishes);

        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(RestaurantDTO restaurantDTO, Long id){

        Restaurant restaurantToUpdate = restaurantRepository.findById(id).get();
        restaurantToUpdate.setName(restaurantDTO.getName());
        restaurantToUpdate.setBorough(restaurantDTO.getBorough());
        restaurantToUpdate.setRating(restaurantDTO.getRating());
        restaurantToUpdate.setPriceRange(restaurantDTO.getPriceRange());

        List<Dish> dishes = new ArrayList<>();

        for (Long dishId : restaurantDTO.getDishIds()){
            dishes.add(dishRepository.findById(dishId).get());
        }

        restaurantToUpdate.setDishes(dishes);
        restaurantRepository.save(restaurantToUpdate);

        return restaurantToUpdate;
    }

    public void deleteRestaurant (Long id){
        restaurantRepository.deleteById(id);
    }

    public List<Restaurant> getRestaurantsByFilters(FilterDTO filterDTO){

        Borough borough = Borough.findByName(filterDTO.getBoroughFilter());
        Cuisine cuisine = Cuisine.findByName(filterDTO.getCuisineFilter());

        List<Restaurant> restaurants = restaurantRepository.findAll();

        if (borough != null && cuisine != null) {
            restaurants = restaurantRepository.findByBoroughAndDishesCuisine(borough, cuisine);

        } else if (cuisine != null) {
            restaurants = restaurantRepository.findByDishesCuisine(cuisine);

        } else if (borough != null) {
            restaurants = restaurantRepository.findByBorough(borough);
        }

        return restaurants;
    }
}


