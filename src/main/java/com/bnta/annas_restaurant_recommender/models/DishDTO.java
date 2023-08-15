package com.bnta.annas_restaurant_recommender.models;

import java.util.List;

public class DishDTO {

    private String name;
    private boolean vegetarian;
    private boolean vegan;
    private boolean dairyFree;
    private boolean halal;
    private List<Long> cuisineIndexes;

    public DishDTO(String name, boolean vegetarian, boolean vegan, boolean dairyFree, boolean halal, List<Long> cuisineIndexes) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.dairyFree = dairyFree;
        this.halal = halal;
        this.cuisineIndexes = cuisineIndexes;
    }

    public DishDTO(){

    }

    //    GETTERS AND SETTERS

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

    public List<Long> getCuisineIndexes() {
        return cuisineIndexes;
    }

    public void setCuisineIndexes(List<Long> cuisineIndexes) {
        this.cuisineIndexes = cuisineIndexes;
    }
}
