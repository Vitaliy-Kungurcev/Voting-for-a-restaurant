package com.example.lunch.entity;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Название блюда не должно быть пустым")
    @Size(min = 2, max = 30, message = "Название блюда должно быть от 2 до 30 символов")
    private String name;

    @Column(name = "price")
    @Min(value = 1, message = "Сумма должна быть больше чем 0 ")
    @Max(value = 10000, message = "Недопустимая сумма")
    private int price;

    @Column(name = "restaurant_id")
    private int restaurant_id;

    public Meal() {
    }

    public Meal(String name, int price) {
        this.name = name;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }
}
