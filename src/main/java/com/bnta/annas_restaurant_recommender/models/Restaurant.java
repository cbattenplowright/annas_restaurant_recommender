package com.bnta.annas_restaurant_recommender.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
//    @Column
    private Borough borough;

    @Column(name = "price_range")
    private PriceRange priceRange;

    @Column
    private int rating;

    @JsonIgnoreProperties({"restaurants"})
    @ManyToMany
    @JoinTable(
            name = "restaurants_dishes",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id"))
    private List<Dish> dishes;

    public Restaurant(String name, Borough borough, PriceRange priceRange, int rating, List<Dish> dishes){
        this.name = name;
        this.borough = borough;
        this.priceRange = priceRange;
        this.rating = rating;
        this.dishes = dishes;
    }

    public Restaurant(){}

    public void removeDish(Dish dish){
        this.dishes.remove(dish);
    }

    //    GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Borough getBorough() {
        return borough;
    }

    public void setBorough(Borough borough) {
        this.borough = borough;
    }

    public PriceRange getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(PriceRange priceRange) {
        this.priceRange = priceRange;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
