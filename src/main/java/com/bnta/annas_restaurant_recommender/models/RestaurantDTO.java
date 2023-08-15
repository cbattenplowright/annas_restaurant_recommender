package com.bnta.annas_restaurant_recommender.models;

import java.util.List;

public class RestaurantDTO {

    private String name;
    private Borough borough;
    private PriceRange priceRange;
    private int rating;
    private List<Long> dishIds;

    public RestaurantDTO(String name, Borough borough, PriceRange priceRange, int rating, List<Long> dishIds) {
        this.name = name;
        this.borough = borough;
        this.priceRange = priceRange;
        this.rating = rating;
        this.dishIds = dishIds;
    }

    public RestaurantDTO() {
    }

    //    GETTERS AND SETTERS
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

    public List<Long> getDishIds() {
        return dishIds;
    }

    public void setDishIds(List<Long> dishIds) {
        this.dishIds = dishIds;
    }
}
