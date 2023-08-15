package com.bnta.annas_restaurant_recommender.repositories;

import com.bnta.annas_restaurant_recommender.models.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
}
