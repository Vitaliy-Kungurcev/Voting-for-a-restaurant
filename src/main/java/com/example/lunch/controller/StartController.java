package com.example.lunch.controller;


import com.example.lunch.entity.Choise;
import com.example.lunch.entity.Restaurant;
import com.example.lunch.service.ChoiseService;
import com.example.lunch.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class StartController {

    @Autowired
    private ChoiseService choiseService;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/")
    public String startPage(Model model) {

        Choise.DateChoise dateChoise = new Choise.DateChoise();

        model.addAttribute("dateChoise", dateChoise);
        model.addAttribute("restId", 0);
        return "startPage";
    }

    @GetMapping("/your_choise")
    public String checkChoise(@AuthenticationPrincipal User user, Model model, RedirectAttributes rm) {
        String userName = user.getUsername();
        Choise choise = choiseService.checkChoiseUser(userName, LocalDate.now());

        if (choise != null) {
            model.addAttribute(choise);
            return "choiseUser";
        }
        rm.addAttribute("userName",userName);
        return "redirect:/choise";
    }

    @GetMapping("/choise")
    public String userChoise(@RequestParam("userName") String userName, Model model) {
        if (LocalTime.now().getHour() > 16) {
            return "errorChoise";
        }

        List<Restaurant> allRestarants = restaurantService.getAllByDate(LocalDate.now());
        model.addAttribute("allRestarants", allRestarants);
        model.addAttribute("userName", userName);

        return "allRestAndMenuUser";
    }


    @GetMapping("/rezult")
    public String rezultChoise(Model model) {
        LocalDate dateToday = LocalDate.now();
        List<Choise> allChoiseToday = choiseService.getChoiseDate(dateToday);
        model.addAttribute("date", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        if (allChoiseToday.size() == 0) {
            return "noChoise";
        }
        model.addAttribute("allChoiseToday", allChoiseToday);


        return "rezultChoiseAdmin";
    }

    @PostMapping("/history")
    public String historyChoise(@RequestParam("localDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate, Model model) {
        List<Choise> historyChoise = choiseService.getChoiseDate(localDate);
        List<Restaurant> historyRestaurantsAndMenu = restaurantService.getAllByDate(localDate);
        model.addAttribute("date", localDate);
        if (historyChoise.size() == 0 && historyRestaurantsAndMenu.size() == 0) {
            return "noChoise";
        }
        model.addAttribute("historyChoise", historyChoise);
        model.addAttribute("historyRestaurantsAndMenu", historyRestaurantsAndMenu);
        return "historyChoiseAdmin";
    }


}
