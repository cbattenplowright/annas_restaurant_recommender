package com.bnta.annas_restaurant_recommender.models;

import java.util.List;

public class FilterDTO {

    private boolean vegetarianFilter;
    private boolean halalFilter;
    private boolean dairyFreeFilter;
    private boolean veganFilter;
    private Borough boroughFilter;
    private List<Cuisine> cuisineFilter;
    private PriceRange priceRangeFilter;

    public FilterDTO(boolean vegetarianFilter, boolean halalFilter, boolean dairyFreeFilter, boolean veganFilter, Borough boroughFilter, List<Cuisine> cuisineFilter, PriceRange priceRangeFilter) {
        this.vegetarianFilter = vegetarianFilter;
        this.halalFilter = halalFilter;
        this.dairyFreeFilter = dairyFreeFilter;
        this.veganFilter = veganFilter;
        this.boroughFilter = boroughFilter;
        this.cuisineFilter = cuisineFilter;
        this.priceRangeFilter = priceRangeFilter;
    }

    public FilterDTO(){}

    //    GETTERS AND SETTERS
    public boolean getVegetarianFilter() {
        return vegetarianFilter;
    }

    public void setVegetarianFilter(boolean vegetarianFilter) {
        this.vegetarianFilter = vegetarianFilter;
    }

    public boolean getHalalFilter() {
        return halalFilter;
    }

    public void setHalalFilter(boolean halalFilter) {
        this.halalFilter = halalFilter;
    }

    public boolean getDairyFreeFilter() {
        return dairyFreeFilter;
    }

    public void setDairyFreeFilter(boolean dairyFreeFilter) {
        this.dairyFreeFilter = dairyFreeFilter;
    }

    public boolean getVeganFilter() {
        return veganFilter;
    }

    public void setVeganFilter(boolean veganFilter) {
        this.veganFilter = veganFilter;
    }

    public Borough getBoroughFilter() {
        return boroughFilter;
    }

    public void setBoroughFilter(Borough boroughFilter) {
        this.boroughFilter = boroughFilter;
    }

    public List<Cuisine> getCuisineFilter() {
        return cuisineFilter;
    }

    public void setCuisineFilter(List<Cuisine> cuisineFilter) {
        this.cuisineFilter = cuisineFilter;
    }

    public PriceRange getPriceRangeFilter() {
        return priceRangeFilter;
    }

    public void setPriceRangeFilter(PriceRange priceRangeFilter) {
        this.priceRangeFilter = priceRangeFilter;
    }
}
