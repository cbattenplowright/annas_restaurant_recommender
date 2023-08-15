package com.bnta.annas_restaurant_recommender.services;

import com.bnta.annas_restaurant_recommender.models.Dish;
import com.bnta.annas_restaurant_recommender.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {

    @Autowired
    DishRepository dishRepository;

    public List<Dish> findAllDishes(){
        return dishRepository.findAll();
    }


}
