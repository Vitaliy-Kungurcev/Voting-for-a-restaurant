package com.example.lunch.entity;



import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;


@Entity
@Table(name = "choise")
public class Choise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "restaurant_id")
    private int restId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "rest_name")
    private String restName;

    @Column(name = "rest_adress")
    private String restAdress;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "date")
    private LocalDate date;

    public Choise() {
    }

    public Choise( int restId, String userName) {

        this.restId = restId;
        this.userName = userName;
    }
    public Choise( String userName, String restName, String restAdress) {

        this.userName = userName;
        this.restName = restName;
        this.restAdress = restAdress;
    }

    public Choise(String userName, String restName, String restAdress, LocalTime time, LocalDate date) {
        this.userName = userName;
        this.restName = restName;
        this.restAdress = restAdress;
        this.time = time;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRestId() {
        return restId;
    }

    public void setRestId(int restId) {
        this.restId = restId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRestName() {
        return restName;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public String getRestAdress() {
        return restAdress;
    }

    public void setRestAdress(String restAdress) {
        this.restAdress = restAdress;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public static class DateChoise {

        private LocalDate localDate;

        public DateChoise() {
        }

        public LocalDate getLocalDate() {
            return localDate;
        }

        public void setLocalDate(LocalDate localDate) {
            this.localDate = localDate;
        }
    }
}

