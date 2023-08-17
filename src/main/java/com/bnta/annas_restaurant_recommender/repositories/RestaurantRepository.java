package com.bnta.annas_restaurant_recommender.repositories;

import com.bnta.annas_restaurant_recommender.models.Borough;
import com.bnta.annas_restaurant_recommender.models.Cuisine;
import com.bnta.annas_restaurant_recommender.models.Dish;
import com.bnta.annas_restaurant_recommender.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Query("SELECT*FROM")
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByBorough(Borough borough);
    List<Restaurant> findByDishesCuisine(Cuisine cuisine);
    List<Restaurant> findByBoroughAndDishesCuisine (Borough borough, Cuisine cuisine);
}
