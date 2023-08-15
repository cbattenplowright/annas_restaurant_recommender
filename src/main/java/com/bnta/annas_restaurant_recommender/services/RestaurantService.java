package com.bnta.annas_restaurant_recommender.services;

import com.bnta.annas_restaurant_recommender.models.Restaurant;
import com.bnta.annas_restaurant_recommender.repositories.DishRepository;
import com.bnta.annas_restaurant_recommender.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
