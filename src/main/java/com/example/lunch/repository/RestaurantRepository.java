package com.example.lunch.repository;


import com.example.lunch.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {


    List<Restaurant> findRestaurantByDate( LocalDate localDate);



}
