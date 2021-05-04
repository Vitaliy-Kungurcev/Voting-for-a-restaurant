//package com.example.lunch.to;
//
//import com.example.lunch.entity.Choise;
//import com.example.lunch.entity.Meal;
//import com.example.lunch.entity.Restaurant;
//import com.example.lunch.service.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import java.util.List;
//
//@Controller
//public class Data {
//    @Autowired
//    RestaurantService restaurantService;
//
//    @Autowired
//    MealService mealService;
//
//    @Autowired
//    ChoiseService choiseService ;
//
//    public void createData() {
//
////        List<Restaurant> allRestaurants = List.of(new Restaurant("Mark i Lev", "ul.Lenina 25"),
////                new Restaurant("Kardamon", "ul.Mira 28"),
////                new Restaurant("Restoran", "ul.Hohryakova 97"),
////                new Restaurant("Gastronomika", "ul.Dekabristov 11"),
////                new Restaurant("Curry House", "ul.Znamenskogo 46"));
////
////        for (Restaurant element : allRestaurants) {
////            restaurantService.save(element);
////        }
//
//
//        mealService.save(new Meal("Borsh", 90), 1);
//        mealService.save(new Meal("Uha", 80), 1);
//        mealService.save(new Meal("Borshch", 100), 2);
//        mealService.save(new Meal("Rassolnik", 110), 2);
//        mealService.save(new Meal("Kurinyj sup", 80), 2);
//        mealService.save(new Meal("Lagman", 140), 3);
//        mealService.save(new Meal("SHurpa", 160), 3);
//        mealService.save(new Meal("Gribnoj sup", 100), 4);
//        mealService.save(new Meal("Ovoshchnoj sup", 80), 4);
//        mealService.save(new Meal("Solyanka", 130), 5);
//        mealService.save(new Meal("Molochnyj mup", 60), 5);
//        mealService.save(new Meal("Kotlety", 70), 1);
//        mealService.save(new Meal("Tefteli", 60), 1);
//        mealService.save(new Meal("Gorbusha pod shuboj ", 140), 2);
//        mealService.save(new Meal("Sosiki", 80), 2);
//        mealService.save(new Meal("Pelmeni", 90), 3);
//        mealService.save(new Meal("ZHarenyj lagman", 160), 3);
//        mealService.save(new Meal("Plov", 150), 3);
//        mealService.save(new Meal("ZHarkoe", 80), 4);
//        mealService.save(new Meal("Ragu ovoshchnoe", 100), 4);
//        mealService.save(new Meal("ZHarenyj okorochka", 80), 5);
//        mealService.save(new Meal("Kotlety", 90), 5);
//        mealService.save(new Meal("Cezar salat", 50), 1);
//        mealService.save(new Meal("Letnij salat", 50), 4);
//        mealService.save(new Meal("Morkovnyj salat", 50), 4);
//        mealService.save(new Meal("Grecheskij salat", 80), 5);
//        mealService.save(new Meal("Svekolnyj salat", 40), 5);
//
//
//        choiseService.save(2, new Choise("elena", "Kardamon", "ul.Mira 28"));
//        choiseService.save(1, new Choise("rita", "Mark i Lev", "ul.Lenina 25"));
//        choiseService.save(5, new Choise("alex", "Curry House", "ul.Znamenskogo 46"));
//        choiseService.save(2, new Choise("egor", "Kardamon", "ul.Mira 28"));
//        choiseService.save(4, new Choise("isa", "Gastronomika", "ul.Dekabristov 11"));
//        choiseService.save(2, new Choise("mila", "Kardamon", "ul.Mira 28"));
//        choiseService.save(2, new Choise("vitaliy", "Kardamon", "ul.Mira 28"));
//
//
//    }
//}
