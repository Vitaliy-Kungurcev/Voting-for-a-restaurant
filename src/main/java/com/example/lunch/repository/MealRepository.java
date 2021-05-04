package com.example.lunch.repository;


import com.example.lunch.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal,Integer> {

}
