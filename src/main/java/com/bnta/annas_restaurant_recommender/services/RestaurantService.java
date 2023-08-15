package com.bnta.annas_restaurant_recommender.services;

import com.bnta.annas_restaurant_recommender.models.Dish;
import com.bnta.annas_restaurant_recommender.models.Restaurant;
import com.bnta.annas_restaurant_recommender.models.RestaurantDTO;
import com.bnta.annas_restaurant_recommender.repositories.DishRepository;
import com.bnta.annas_restaurant_recommender.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    DishRepository dishRepository;

    public List<Restaurant> findAllRestaurants(){
        return restaurantRepository.findAll();
    }

    public Restaurant findRestaurant(Long id){
        return restaurantRepository.findById(id).get();
    }

    public void saveRestaurant (RestaurantDTO restaurantDTO){
        List<Dish> dishes = new ArrayList<>();
        for (Long dishId : restaurantDTO.getDishIds()){
            dishes.add(dishRepository.findById(dishId).get());
        }
        Restaurant restaurant = new Restaurant(restaurantDTO.getName(), restaurantDTO.getBorough(), restaurantDTO.getPriceRange(), restaurantDTO.getRating(), dishes);

        restaurantRepository.save(restaurant);

    }

}
