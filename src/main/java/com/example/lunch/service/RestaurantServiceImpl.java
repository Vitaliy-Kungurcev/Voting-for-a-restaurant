package com.example.lunch.service;//package com.example.lunch.dao;


import com.example.lunch.repository.RestaurantRepository;
import com.example.lunch.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    @Cacheable("restaurants")
    public List<Restaurant> getAllByDate(LocalDate date) {
        return restaurantRepository.findRestaurantByDate(date);
    }

    @Override
    @CacheEvict( value = "restaurants",allEntries=true )
    public boolean save(Restaurant restaurant) {
       if (restaurant.getId() != 0 )  {
            Restaurant restaurant1 = get(restaurant.getId());
            restaurant.setMeals(restaurant1.getMeals());
            restaurant.setChoises(restaurant1.getChoises());
        }
          try {
              restaurantRepository.save(restaurant);
          }catch (DataIntegrityViolationException dataIntegrityViolationException){
             return false;
          }return true;
    }

    @Override
    public Restaurant get(int id) {
        Restaurant restaurant = null;
        Optional<Restaurant> optional = restaurantRepository.findById(id);
        if (optional.isPresent()) {
            restaurant = optional.get();
        }
        return restaurant;
    }


    @Override
    @CacheEvict( value = "restaurants",allEntries=true )
    public void delete(int id) {
    restaurantRepository.deleteById(id);
    }




}


