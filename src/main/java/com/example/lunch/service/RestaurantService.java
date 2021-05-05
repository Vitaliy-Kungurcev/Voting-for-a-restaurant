package com.example.lunch.service;


import com.example.lunch.entity.Restaurant;

import java.time.LocalDate;
import java.util.List;

public interface RestaurantService  {



    List<Restaurant> getAllByDate(LocalDate date);

    boolean save(Restaurant restaurant);

    Restaurant get(int id);

    void delete(int id);




}
