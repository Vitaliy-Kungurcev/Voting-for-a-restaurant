package com.example.lunch.controller;


import com.example.lunch.entity.Meal;
import com.example.lunch.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/restaurants/menu")
public class MealController {

    @Autowired
    MealService mealService;

    @GetMapping("/create")
    public String createMeal(@RequestParam("restId") int restId, Model model) {
        Meal meal = new Meal();
        meal.setRestaurant_id(restId);
        model.addAttribute("namePage", "create");
        model.addAttribute("meal", meal);
        return "mealForm";
    }

    @GetMapping("/update")
    public String updateMeal(@RequestParam("mealId") int mealId,  Model model) {
        Meal meal = mealService.get(mealId);
        model.addAttribute("meal", meal);
        return "mealForm";
    }

    @GetMapping("/delete")
    public String deleteMeal(@RequestParam("mealId") int mealId, @RequestParam("restId") int restId, RedirectAttributes rm) {
        mealService.delete(mealId);
        rm.addAttribute("restId", restId);
        return "redirect:/restaurants/menu";
    }


    @PostMapping("/save")
    public String saveMeal( @ModelAttribute("meal") @Valid Meal meal,
                           BindingResult bindingResult, RedirectAttributes rm,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("meal", meal);
            return "mealForm";
        }

        mealService.save(meal);
        rm.addAttribute("restId", meal.getRestaurant_id());
        return "redirect:/restaurants/menu";
    }


}
