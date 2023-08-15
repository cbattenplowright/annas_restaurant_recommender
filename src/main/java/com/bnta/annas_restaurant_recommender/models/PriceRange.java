package com.bnta.annas_restaurant_recommender.models;

public enum PriceRange {
    LOW("£"),
    MEDIUM("££"),
    HIGH("£££");

    private final String displayPrice;

    PriceRange(String displayPrice){
        this.displayPrice = displayPrice;
    }

    public String getDisplayPrice(){
        return displayPrice;
    }
}

