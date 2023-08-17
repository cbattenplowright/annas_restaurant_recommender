package com.bnta.annas_restaurant_recommender.models;

import java.util.List;

public class FilterDTO {

    private Boolean vegetarianFilter;
    private Boolean halalFilter;
    private Boolean dairyFreeFilter;
    private Boolean veganFilter;
    private String boroughFilter;
    private String cuisineFilter;
    private PriceRange priceRangeFilter;

    public FilterDTO(Boolean vegetarianFilter, Boolean halalFilter, Boolean dairyFreeFilter, Boolean veganFilter, String boroughFilter, String cuisineFilter, PriceRange priceRangeFilter) {
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

    public Boolean getVegetarianFilter() {
        return vegetarianFilter;
    }

    public void setVegetarianFilter(Boolean vegetarianFilter) {
        this.vegetarianFilter = vegetarianFilter;
    }

    public Boolean getHalalFilter() {
        return halalFilter;
    }

    public void setHalalFilter(Boolean halalFilter) {
        this.halalFilter = halalFilter;
    }

    public Boolean getDairyFreeFilter() {
        return dairyFreeFilter;
    }

    public void setDairyFreeFilter(Boolean dairyFreeFilter) {
        this.dairyFreeFilter = dairyFreeFilter;
    }

    public Boolean getVeganFilter() {
        return veganFilter;
    }

    public void setVeganFilter(Boolean veganFilter) {
        this.veganFilter = veganFilter;
    }

    public String getBoroughFilter() {
        return boroughFilter;
    }

    public void setBoroughFilter(String boroughFilter) {
        this.boroughFilter = boroughFilter;
    }

    public String getCuisineFilter() {
        return cuisineFilter;
    }

    public void setCuisineFilter(String cuisineFilter) {
        this.cuisineFilter = cuisineFilter;
    }

    public PriceRange getPriceRangeFilter() {
        return priceRangeFilter;
    }

    public void setPriceRangeFilter(PriceRange priceRangeFilter) {
        this.priceRangeFilter = priceRangeFilter;
    }


}
