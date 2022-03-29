package com.example.dentalapplicationproject.DB;


import android.widget.ImageView;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DoctorImages {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int doctorId;
    private Integer image;

    public DoctorImages(int doctorId, Integer image) {
        this.doctorId = doctorId;
        this.image = image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public Integer getImage() {
        return image;
    }
}

