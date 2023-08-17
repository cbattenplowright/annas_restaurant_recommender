package com.bnta.annas_restaurant_recommender.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table( name = "dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private boolean vegetarian;

    @Column
    private boolean vegan;

    @Column (name = "dairy_free")
    private boolean dairyFree;

    @Column
    private boolean halal;

    @Enumerated(EnumType.STRING)
    private Cuisine cuisine;

    @JsonIgnoreProperties({"dishes"})
    @ManyToMany(mappedBy = "dishes")
    private List<Restaurant> restaurants;

    public Dish(String name, boolean vegetarian, boolean vegan, boolean dairyFree, boolean halal, Cuisine cuisine) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.dairyFree = dairyFree;
        this.halal = halal;
        this.cuisine = cuisine;
    }

    public Dish(){

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

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isDairyFree() {
        return dairyFree;
    }

    public void setDairyFree(boolean dairyFree) {
        this.dairyFree = dairyFree;
    }

    public boolean isHalal() {
        return halal;
    }

    public void setHalal(boolean halal) {
        this.halal = halal;
    }

    public Cuisine getCuisines() {
        return cuisine;
    }

    public void setCuisines(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
