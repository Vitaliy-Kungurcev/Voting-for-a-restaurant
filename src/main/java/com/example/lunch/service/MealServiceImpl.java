package com.example.lunch.service;


import com.example.lunch.repository.MealRepository;
import com.example.lunch.entity.Meal;
import com.example.lunch.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealServiceImpl implements MealService {


    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private RestaurantService restaurantService;


    @Override
    @CacheEvict( value = "restaurants",allEntries=true )
    public void save(Meal meal, int restId) {

        if (meal.getId() == 0) {
            Restaurant restaurant = restaurantService.get(restId);
            restaurant.addMealToRestaurant(restaurant, meal);
        }

        mealRepository.save(meal);
    }

    @Override

    public Meal get(int id) {
        Meal meal = null;
        Optional<Meal> optional = mealRepository.findById(id);
        if (optional.isPresent()) {
            meal = optional.get();
        }
        return meal;
    }

    @Override
    @CacheEvict( value = "restaurants",allEntries=true )
    public void delete(int id) {

        mealRepository.deleteById(id);
    }




}
