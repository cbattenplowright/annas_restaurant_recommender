package com.bnta.annas_restaurant_recommender.repositories;

import com.bnta.annas_restaurant_recommender.models.Borough;
import com.bnta.annas_restaurant_recommender.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByBorough(Borough borough);
}
