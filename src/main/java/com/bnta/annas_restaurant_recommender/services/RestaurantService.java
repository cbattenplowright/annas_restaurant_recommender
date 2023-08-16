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
        Restaurant restaurant = new Restaurant(restaurantDTO.getName(), restaurantDTO.getBorough(), restaurantDTO.getPriceRange(), restaurantDTO.getRating(), dishes);

        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(RestaurantDTO restaurantDTO,Long id){
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

    public List<Restaurant> getRestaurantsByBorough(Borough borough){
        return restaurantRepository.findByBorough(borough);
    }

    public List<Restaurant> getRestaurantByCuisine(List<String> cuisines){
        List<Cuisine> cuisines
        for (String cuisine: cuisines){
            Cuisine.findByName(cuisine);
        }
        List<Dish> dishes = restaurantRepository.findByDishesCuisines(cuisines);
        List<Restaurant> listOfRestaurants = restaurantRepository.findByDishes(dishes);
        return listOfRestaurants;
    }

}
