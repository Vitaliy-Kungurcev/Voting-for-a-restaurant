package com.example.lunch.controller;


import com.example.lunch.entity.Choise;
import com.example.lunch.service.ChoiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
@RequestMapping("/choise")
public class ChoiseController {

    @Autowired
    private ChoiseService choiseService;

    @PostMapping("/create")
    public String createChoise(@RequestParam("choiseinput") int restId, @RequestParam("userName") String userName) {
        Choise choise = new Choise(restId, userName);
        choise.setDate(LocalDate.now());
        choise.setTime(LocalTime.now());

        choiseService.save(choise);

        return "redirect:/choise/your";
    }

    @GetMapping("/your")
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


    @GetMapping("/update")
    public String updateChoise() {
        return "redirect:/choise/your";
    }
}
