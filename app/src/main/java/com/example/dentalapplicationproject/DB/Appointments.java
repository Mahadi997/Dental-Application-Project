package com.example.dentalapplicationproject.DB;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Appointments {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int userId;
    private int day;
    private int month;
    private int year;
    private String status;


    public Appointments(int userId, int day, int month, int year, String status) {

        this.userId = userId;
        this.day = day;
        this.month = month;
        this.year = year;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getStatus() {
        return status;
    }
}
