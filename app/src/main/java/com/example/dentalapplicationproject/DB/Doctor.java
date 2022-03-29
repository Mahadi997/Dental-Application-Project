package com.example.dentalapplicationproject.DB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Doctor {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String description;

    public void setId(int id) {
        this.id = id;
    }

    public Doctor(String name, String surname, String description, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.description = description;
        this.email = email;
        this.password = password;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDescription() {
        return description;
    }


}
