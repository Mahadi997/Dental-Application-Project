package com.example.dentalapplicationproject.DB;


import android.widget.ImageView;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DoctorImages {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int doctorId;
    private byte[] image;

    public DoctorImages(int doctorId, byte[] image) {
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

    public byte[] getImage() {
        return image;
    }
}

