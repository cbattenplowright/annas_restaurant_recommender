package com.bnta.annas_restaurant_recommender.models;

import jakarta.persistence.Entity;


public enum Cuisine {

    AMERICAN ("American"),
    BRITISH ("British"),
    CHINESE ("Chinese"),
    FRENCH ("French"),
    GREEK ("Greek"),
    INDIAN ("Indian"),
    ITALIAN("Italian"),
    JAPANESE("Japanese"),
    KENYAN ("Kenyan"),
    KOREAN ("Korean"),
    MEDITERRANEAN ("Mediterranean"),
    MEXICAN ("Mexican"),
    NIGERIAN("Nigerian"),
    PAKISTANI("Pakistani"),
    THAI("Thai"),
    TURKISH("Turkish"),
    SOMALIAN("Somalian"),
    VIETNAMESE("Vietnamese"),
    ZIMBABWEAN ("Zimbabwean");

    private final String displayCuisineName;

    Cuisine (String displayCuisineName){

        this.displayCuisineName = displayCuisineName;
    }

    public String getCuisineName(){

        return displayCuisineName;
    }

    public static Cuisine valueFromDisplayCuisineName (String displayCuisineName) {

        for (Cuisine cuisine : values()) {
            if (cuisine.displayCuisineName.equals(displayCuisineName)) {
                return cuisine;
            }
        }
        return null;
    }

    public static Cuisine findByName(String cuisineName){

        Cuisine result = null;

        for (Cuisine cuisine : values()){
            if (cuisine.name().equalsIgnoreCase(cuisineName)){
                result = cuisine;
                break;
            }
        }
        return result;
    }
}
