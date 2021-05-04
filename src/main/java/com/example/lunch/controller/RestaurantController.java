package com.example.lunch.controller;


import com.example.lunch.entity.Restaurant;
import com.example.lunch.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/restaurants/")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    private LocalDate dateToday = LocalDate.now();

    private String dateTodayString = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    @GetMapping("/")
    @CacheEvict( value = "restaurants",allEntries=true )
    public String allRestarants(Model model) {
        List<Restaurant> allRestarants = restaurantService.getAllByDate(LocalDate.now());
        model.addAttribute("allRestarants", allRestarants);
        model.addAttribute("dateToday", dateTodayString);
        return "allRestAdmin";
    }

    @GetMapping("/create")
    public String createRestaurant(Model model) {
        Restaurant restaurant = new Restaurant(dateToday);
        String name = "create";
        model.addAttribute("namePage", name);
        model.addAttribute("restaurant", restaurant);
        return "restaurantForm";
    }

    @GetMapping("/update")
    public String updateRestarant(@RequestParam("restId") int id, Model model) {
        Restaurant restaurant = restaurantService.get(id);
        restaurant.setDate(dateToday);
        model.addAttribute("restaurant", restaurant);
        return "restaurantForm";
    }


    @PostMapping("/save")
    public String saveRestarant(@Valid @ModelAttribute("restaurant") Restaurant restaurant, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "restaurantForm";
        }
        restaurantService.save(restaurant);
        return "redirect:/restaurants/";
    }

    @GetMapping("/delete")

    public String deleteRestaurant(@RequestParam("restId") int id) {
        restaurantService.delete(id);
        return "redirect:/restaurants/";
    }

    @GetMapping("/menu")
    public String updateMenu(@RequestParam("restId") int restId, Model model) {
        Restaurant restaurant = restaurantService.get(restId);
        model.addAttribute("restId", restId);
        model.addAttribute("nameRest", restaurant.getName());
        model.addAttribute("mealsAll", restaurant.getMeals());
        return "menuAdmin";
    }


}
