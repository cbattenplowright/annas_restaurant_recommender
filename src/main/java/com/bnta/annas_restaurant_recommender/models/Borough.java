package com.bnta.annas_restaurant_recommender.models;

public enum Borough {

    BARKINGANDDAGENHAM("Barking and Dagenham"),
    BARNET("Barnet"),
    BEXLEY("Bexley"),
    BRENT("Brent"),
    BROMLEY("Bromley"),
    CAMDEN("Camden"),
    CROYDON("Croydon"),
    EALING("Ealing"),
    ENFIELD("Enfield"),
    GREENWICH("Greenwich"),
    HACKNEY("Hackney"),
    HAMMERSMITHANDFULHAM("Hammersmith and Fulham"),
    HARINGEY("Haringey"),
    HARROW("Harrow"),
    HAVERING("Havering"),
    HILLINGDON("Hillingdon"),
    HOUNSLOW("Hounslow"),
    ISLINGTON("Islington"),
    KENSINGTONANDCHELSEA("Kensington and Chelsea"),
    KINGSTONUPONTHAMES("Kingston upon Thames"),
    LAMBETH("Lambeth"),
    LEWISHAM("Lewisham"),
    MERTON("Merton"),
    NEWHAM("Newham"),
    REDBRIDGE("Redbridge"),
    RICHMONDUPONTHAMES("Richmond upon Thames"),
    SOUTHWARK("Southwark"),
    SUTTON("Sutton"),
    TOWERHAMLETS("Tower Hamlets"),
    WALTHAMFOREST("Waltham Forest"),
    WANDSWORTH("Wandsworth"),
    WESTMINSTER("Westminster");

    private final String displayBoroughName;

    Borough(String displayBoroughName) {
        this.displayBoroughName = displayBoroughName;
    }

    public String getBoroughName() {
        return displayBoroughName;
    }

    public static String findByName(String name){
        String result = null;
        for (Borough borough : values()){
            if (borough.name().equalsIgnoreCase(name)){
                result = borough.displayBoroughName;
                break;
            }
        } return result;
    }

}
