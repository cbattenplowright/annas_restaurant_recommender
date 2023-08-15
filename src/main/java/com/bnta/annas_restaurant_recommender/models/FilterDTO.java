package com.bnta.annas_restaurant_recommender.models;

public class FilterDTO {

    private Boolean vegetarianFilter;
    private Boolean halalFilter;
    private Boolean dairyFreeFilter;
    private Boolean veganFilter;
    private Borough boroughFilter;
    private Cuisine cuisineFilter;
    private PriceRange priceRangeFilter;

    public FilterDTO(Boolean vegetarianFilter, Boolean halalFilter, Boolean dairyFreeFilter, Boolean veganFilter, Borough boroughFilter, Cuisine cuisineFilter, PriceRange priceRangeFilter) {
        this.vegetarianFilter = vegetarianFilter;
        this.halalFilter = halalFilter;
        this.dairyFreeFilter = dairyFreeFilter;
        this.veganFilter = veganFilter;
        this.boroughFilter = boroughFilter;
        this.cuisineFilter = cuisineFilter;
        this.priceRangeFilter = priceRangeFilter;
    }

    public FilterDTO(){}

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

    public Borough getBoroughFilter() {
        return boroughFilter;
    }

    public void setBoroughFilter(Borough boroughFilter) {
        this.boroughFilter = boroughFilter;
    }

    public Cuisine getCuisineFilter() {
        return cuisineFilter;
    }

    public void setCuisineFilter(Cuisine cuisineFilter) {
        this.cuisineFilter = cuisineFilter;
    }

    public PriceRange getPriceRangeFilter() {
        return priceRangeFilter;
    }

    public void setPriceRangeFilter(PriceRange priceRangeFilter) {
        this.priceRangeFilter = priceRangeFilter;
    }
}
