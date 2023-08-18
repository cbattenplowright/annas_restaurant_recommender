# Anna's Restaurant Recommender - ARE YOU HUNGRY? JUST SEARCH 
## Description
This is a data API project which recommends London restaurants based on location and cuisine. Each restaurant contains a borough, cuisine, price range and rating (out of 5), as well as a list of dishes that are served. Dishes are characterised by whether they meet certain dietary requirements, such as being halal or vegetarian. 

The program allows for the user to be recommended restaurants based on their borough of choice, cuisine of choice, or both borough and cuisine at once. 

## MVP

Each model - Restaurant and Dish - have REST controllers that provide basic CRUD functionality:

**For Restaurants:**
- Create a new restaurant 
- Display all available restaurants
- Display details of a specific restaurant
- Update the details of a specific restaurant
- Delete a restaurant

**For Dishes:**
- Create a new dish
- Display all available dishes
- Display details of a specific dish
- Delete a dish

**Filtering**

As part of the MVP, the user is also able to get a list of restaurants based on a given borough and a given cuisine. The names of those are already defined in the following ENUM files:

- Boroughs: annas_restaurant_recommender/models/Borough.java
- Cuisines: annas_restaurant_recommender/models/Cuisine.java

In order to do the filtering you ONLY can use the values showed in those files.

## Setup instructions
To access the endpoints of the program, use https://localhost:{port}/{endpoint} - the default port is 8080 but any can be used.  

## The RESTful route endpoints:

The REST controllers provide GET, POST, PUT and DELETE routes as well as routes to obtain a list of restaurants filtered by borough, by cuisine and any combination of both.


### GET
- `localhost:8080/restaurants`
- `localhost:8080/restaurants?borough={boroughName}`
- `localhost:8080/restaurants?cuisine={cuisineName}`
- `localhost:8080/restaurants?cuisine={cuisineName}&borough={boroughName}`
- `localhost:8080/restaurants/{id}`
- `localhost:8080/dishes`
- `localhost:8080/dishes/{id}`

### POST
- `localhost:8080/restaurants`
- `localhost:8080/dishes`

### PUT
- `localhost:8080/restaurants/{id}`


### DELETE
- `localhost:8080/restaurants/{id}`
- `localhost:8080/dishes/{id}`

## Extensions
- Filter by price range, dietary requirements, rating
- Enum handling in SQL
- User creation with wishlist
- User creation with restaurants visited
- Create recommendations (“close match”) list based on previous filters selected


## Entity Relationship Diagram
<img src = "./src/main/resources/diagrams/RestaurantRecommendation_ERD.png" alt= "entity relationship diagram"/>

## Class Diagram
<img src ="./src/main/resources/diagrams/RestaurantRecommendation_Class Diagram.png" alt= "class diagram"/>


## Tech Stack

The technologies used for this project are:

- Intelliji IDEA, running JDK 17
- Spring Initializer
- Postman
- Postico

## Dependencies

- SpringBoot Web
- SpringBoot DevTools
- PostgreSQL
- SpringBoot Starter Data JPA


## Collaborators

- Amelie Boyd-Shire
- Callum-David Batten-Plowright
- Muhammad Faran Sarwar
- Sandra Martinez Dominguez
- Yihang Chen
