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

    @Autowired
    RestaurantRepository restaurantRepository;

    public List<Dish> findAllDishes() {
        return dishRepository.findAll();
    }

    public Optional<Dish> findDishById(Long id) {
        return dishRepository.findById(id);
    }

    public Dish saveDish(DishDTO dishDTO) {

//        get cuisines by cuisine ids
//        add that cuisine list to Dish

        List<Cuisine> cuisineList = new ArrayList<>();
        for (String cuisineName : dishDTO.getCuisineNames()) {
            cuisineList.add(Cuisine.valueFromDisplayCuisineName(cuisineName));
        }

        Dish newDish = new Dish(
                dishDTO.getName(),
                dishDTO.isVegetarian(),
                dishDTO.isVegan(),
                dishDTO.isDairyFree(),
                dishDTO.isHalal(),
                cuisineList);

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

    public List<Cuisine> checkCuisineExists(DishDTO dishDTO) {
        List<Cuisine> findCuisine = new ArrayList<>();
        for (String cuisineName : dishDTO.getCuisineNames()) {
            findCuisine.add(Cuisine.findByName(cuisineName));
        }
        return findCuisine;
    }

}
