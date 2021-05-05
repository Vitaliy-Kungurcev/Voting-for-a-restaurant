package com.example.lunch.service;


import com.example.lunch.entity.Meal;

import java.util.List;

public interface MealService {

    Meal get(int id);

    void delete(int id);

    void save(Meal meal);
}
