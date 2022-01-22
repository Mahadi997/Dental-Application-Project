package com.example.dentalapplicationproject.DB;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity()
public class Appointments {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int userId;
    private int day;
    private  String s_day;
    private int month;
    private int year;
    private String status;
    private String time;


    public Appointments(int userId, int day, String s_day, int month, int year, String status, String time) {
        this.userId = userId;
        this.day = day;
        this.s_day = s_day;
        this.month = month;
        this.year = year;
        this.status = status;
        this.time = time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTime(String time) {
        this.time = time;
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

    public String getS_day() {
        return s_day;
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

    public String getTime() {
        return time;
    }
}
