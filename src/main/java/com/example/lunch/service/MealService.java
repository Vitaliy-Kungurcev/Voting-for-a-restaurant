package com.example.lunch.service;


import com.example.lunch.entity.Meal;

import java.util.List;

public interface MealService {

    void  save(Meal meal, int id);


    Meal get(int id);

    void delete(int id);




}
