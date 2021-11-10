package com.example.dentalapplicationproject.DB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Doctor {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String surname;
    private String description;
    private Integer image;

    public Doctor(String name, String surname, String description, Integer image) {
        this.name = name;
        this.surname = surname;
        this.description = description;
        this.image = image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDescription() {
        return description;
    }

    public Integer getImage() {
        return image;
    }
}
