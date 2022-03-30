package com.example.dentalapplicationproject.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DoctorImagesDao {


    @Insert
    void insertImage(DoctorImages image);

    @Update
    void updateImage(DoctorImages image);

    @Delete
    void deleteImage(DoctorImages image);

    @Query("SELECT * FROM doctorimages")
    List<DoctorImages> getAllImages();


    @Query("SELECT * FROM doctorimages WHERE doctorId=:doctorId")
    List<DoctorImages> getImagesByDoctorId(int  doctorId);




}
