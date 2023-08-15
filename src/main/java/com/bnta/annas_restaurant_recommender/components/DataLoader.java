package com.bnta.annas_restaurant_recommender.components;

import com.bnta.annas_restaurant_recommender.models.*;
import com.bnta.annas_restaurant_recommender.repositories.DishRepository;
import com.bnta.annas_restaurant_recommender.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner{

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    DishRepository dishRepository;

    public DataLoader(){}

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Dish dish1 = new Dish("Sushi", false, false, true, true, List.of(Cuisine.JAPANESE));
        Dish dish2 = new Dish("Spaghetti Bolognese", false, false, false, true, List.of(Cuisine.ITALIAN));
        Dish dish3 = new Dish("Tacos", false, false, true, false, List.of(Cuisine.MEXICAN));
        Dish dish4 = new Dish("Siu Mai", false, false, true, false, List.of(Cuisine.CHINESE));
        Dish dish5 = new Dish("Margherita Pizza", true, false, false, true, List.of(Cuisine.ITALIAN));
        Dish dish6 = new Dish("Grass", true, true, true, true, List.of(Cuisine.MEDITERRANEAN));
        Dish dish7 = new Dish("Fish and Chips", false, false, true, true, List.of(Cuisine.BRITISH));
        Dish dish8 = new Dish("Lamb Biryani", false, false, false, true, List.of(Cuisine.PAKISTANI));
        Dish dish9 = new Dish("Hawaiian Pizza", false, false, false, false, List.of(Cuisine.AMERICAN, Cuisine.ITALIAN));
        Dish dish10 = new Dish("Burrito", false, false, false, false, List.of(Cuisine.AMERICAN, Cuisine.MEXICAN));
        Dish dish11 = new Dish("Chicken Souvlaki Banh Mi", false, false, false, true, List.of(Cuisine.GREEK, Cuisine.VIETNAMESE));


        dishRepository.saveAll(List.of(dish1, dish2, dish3, dish4, dish5, dish6, dish7, dish8, dish9, dish10, dish11));

//        List<Restaurant> restaurants = new ArrayList<>();
//        restaurants.add(new Restaurant("Bob's Kitchen", Borough.SOUTHWARK.getBoroughName(), PriceRange.MEDIUM.getDisplayPrice(), 3, ))



    }
}
