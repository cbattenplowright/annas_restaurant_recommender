# Anna's Restaurant Recommender - ARE YOU HUNGRY? JUST SEARCH 

## Description
This is a data API project which recommends London restaurants based on location (borough), cuisine and dish. 


## MVP

The MVP have the CRUD functionality that enable the user to:

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
The user is able to get a list of restaurants based on a given borough and a given cuisine. The names of those are already defined in the following ENUM files:

- Boroughs: annas_restaurant_recommender/models/Borough.java
- Cuisines: annas_restaurant_recommender/models/Cuisine.java

In order to do the filtering you ONLY can use the values showed in these files.


## Extensions
- Filter by price range, dietary requirements, rating
- Enum handling in SQL
- User creation with wishlist
- User creation with restaurants visited
- Create recommendations (“close match”) list based on previous filters selected


## Setup instructions
To access the endpoints of the program, use https://localhost:{port}/{endpoint} - the default port is 8080 but any can be used.

Each model - Restaurant and Dish - have REST controllers that provide basic CRUD functionality, specifically Get, Post, Put, and Delete routes. 

## The RESTful route endpoints:

### GET
- localhost:8080/restaurants
- localhost:8080/restaurants?borough={boroughName}
- localhost:8080/restaurants?cuisine={cuisineName}
- localhost:8080/restaurants?cuisine={cuisineName}&borough={boroughName}
- localhost:8080/restaurants/{id}
- localhost:8080/dishes
- localhost:8080/dishes/{id}

### POST
- localhost:8080/restaurants
- localhost:8080/dishes

### PUT
- localhost:8080/restaurants/{id}


### DELETE
- localhost:8080/restaurants/{id}
- localhost:8080/dishes/{id}

## Entity Relationship Diagram



## Tech Stack

The technologies used for this project are:

- Intelliji IDEA, running JDK 17
- Spring Initializer
- Postman
- Postico

## Dependencies

- SpringBoot Starter Web
- SpringBoot Devtools
- PostgreSQL
- SpringBoot Starter Data JPA


## Collaborators

- Amelie Boyd-Shire
- Callum-David Batten-Plowright
- Muhammad Faran Sarwar
- Sandra Martinez Dominguez
- Yihang Chen


Checklist:
A high-level description of the project's aims
The names and versions of any libraries used            DONE
Step-by-step setup instructions 
Links to any relevant diagrams such as ERDs or class diagrams
A full list of example routes (or a link to one) including:         Done
Full urls including placeholders for variables (localhost:8080/users/:id)           Done
Permitted requests for each route (GET, POST, etc)          Done
Examples of permitted requests where appropriate            Done
Examples of responses 
Routes should be organised by route and not by request method
Details of the project's MVP and any extensions covered, or a link to it