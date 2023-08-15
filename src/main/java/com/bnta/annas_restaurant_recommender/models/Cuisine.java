package com.bnta.annas_restaurant_recommender.models;

public enum Cuisine {

    AMERICAN ("American"),
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


}
