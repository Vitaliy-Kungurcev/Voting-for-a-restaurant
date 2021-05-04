package com.example.lunch.service;


import com.example.lunch.entity.Choise;

import java.time.LocalDate;
import java.util.List;

public interface ChoiseService {

    Choise save(Choise choise);

    Choise checkChoiseUser(String username, LocalDate now);

    List<Choise> getChoiseDate(LocalDate localDate);
}
