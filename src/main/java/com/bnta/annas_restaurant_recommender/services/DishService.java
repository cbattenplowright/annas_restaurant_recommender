package com.bnta.annas_restaurant_recommender.services;

import com.bnta.annas_restaurant_recommender.models.Cuisine;
import com.bnta.annas_restaurant_recommender.models.Dish;
import com.bnta.annas_restaurant_recommender.models.DishDTO;
import com.bnta.annas_restaurant_recommender.repositories.DishRepository;
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

}
