package com.example.lunch.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"name" , "date"})})
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name" )
    @NotEmpty(message = "Название не должно быть пустым")
    @Size(min = 2, max = 30, message = "Название должно быть от 2 до 30 символов")
    private String name;

    @Column(name = "adress", nullable = false)
    @NotEmpty(message = "Адрес не должно быть пустым")
    @Size(min = 2, max = 45, message = "Поле должно быть от 2 до 45 символов")
    private String adress;

    @Column(name = "date")
    private LocalDate date;

    @OneToMany(cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    private List<Meal> meals;

    @OneToMany(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private List<Choise> choises;

    public Restaurant() {
    }

    public Restaurant(String name, String adress,LocalDate date) {
        this.name = name;
        this.adress = adress;
        this.date = date;
    }

    public Restaurant(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }

    public Restaurant(LocalDate date) {
        this.date = date;
    }

    public void addMealToRestaurant(Restaurant restaurant, Meal meal) {
        if (restaurant.getMeals() == null) {
            restaurant.setMeals(new ArrayList<>());
        }
        restaurant.getMeals().add(meal);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public List<Choise> getChoises() {
        return choises;
    }

    public void setChoises(List<Choise> choises) {
        this.choises = choises;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
