package com.bnta.annas_restaurant_recommender.services;

import com.bnta.annas_restaurant_recommender.models.Cuisine;
import com.bnta.annas_restaurant_recommender.models.Dish;
import com.bnta.annas_restaurant_recommender.models.DishDTO;
import com.bnta.annas_restaurant_recommender.models.Restaurant;
import com.bnta.annas_restaurant_recommender.repositories.DishRepository;
import com.bnta.annas_restaurant_recommender.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DishService {

    @Autowired
    DishRepository dishRepository;

    public List<Dish> findAllDishes() {
        return dishRepository.findAll();
    }

    public Optional<Dish> findDishById(Long id) {
        return dishRepository.findById(id);
    }

    public Dish saveDish(DishDTO dishDTO) {

//        get cuisine by cuisine id
//        add that cuisine to Dish

        Cuisine cuisine = Cuisine.valueFromDisplayCuisineName(dishDTO.getCuisineName());

        Dish newDish = new Dish(
                dishDTO.getName(),
                dishDTO.isVegetarian(),
                dishDTO.isVegan(),
                dishDTO.isDairyFree(),
                dishDTO.isHalal(),
                cuisine);

        dishRepository.save(newDish);

        return newDish;
    }

    public void removeDish(Long id){

        Dish dish = dishRepository.findById(id).get();

        for (Restaurant restaurant : dish.getRestaurants()){
            restaurant.removeDish(dish);
        }
        dishRepository.delete(dish);
    }

    public Cuisine checkCuisineExists(DishDTO dishDTO) {

        Cuisine findCuisine = Cuisine.findByName(dishDTO.getCuisineName());

        return findCuisine;
    }
}
