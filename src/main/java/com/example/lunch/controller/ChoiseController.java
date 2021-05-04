package com.example.lunch.controller;


import com.example.lunch.entity.Choise;
import com.example.lunch.service.ChoiseService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
@RequestMapping("/choise")
public class ChoiseController {

    @Autowired
    private ChoiseService choiseService;

    @PostMapping("/create")
    public String createChois(@RequestParam("choiseinput") int restId, @RequestParam("userName") String choiseUserName) {
        Choise choise = new Choise(restId, choiseUserName);

        choise.setDate(LocalDate.now());
        choise.setTime(LocalTime.now());

        Choise choise1 = choiseService.save(choise);

        return "redirect:/your_choise";
    }


    @GetMapping("/update")
    public String updateChoise() {

        return "redirect:/your_choise";
    }


}
