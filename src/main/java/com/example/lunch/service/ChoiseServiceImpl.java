package com.example.lunch.service;


import com.example.lunch.entity.Choise;
import com.example.lunch.entity.Restaurant;
import com.example.lunch.repository.ChoiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ChoiseServiceImpl implements ChoiseService {

    @Autowired
    private ChoiseRepository choiseRepository;

    @Autowired
    private RestaurantService restaurantService;

    @Override
    public Choise save(Choise choise) {
        Restaurant restaurant = restaurantService.get(choise.getRestId());
        choise.setRestName(restaurant.getName());
        choise.setRestAdress(restaurant.getAdress());

       try{ choiseRepository.save(choise);
           return choise;
    }catch (DataIntegrityViolationException dataIntegrityViolationException){
         Choise updateChoise=choiseRepository.findByUserNameAndDate(choise.getUserName(),choise.getDate());
         choise.setId(updateChoise.getId());
         choiseRepository.save(choise);
         return choise;
           }
       }


    @Override
    public Choise checkChoiseUser(String username, LocalDate date) {
        return choiseRepository.findByUserNameAndDate(username,date);
    }


    @Override
    public List<Choise> getChoiseDate(LocalDate localDate) {
        return choiseRepository.getChoiseDate(localDate);
    }



}
