package com.example.dentalapplicationproject.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DoctorDao {

    @Insert
    void insertDoctor(Doctor doctor);

    @Update
    void updateDoctor(Doctor doctor);

    @Delete
    void deleteDoctor(Doctor doctor);

    @Query("SELECT * FROM doctor")
    List<Doctor> getAllDoctors();


    @Query("SELECT * FROM doctor WHERE id=:id")
    List<Doctor> getDoctorById(int id);

    @Query("SELECT * FROM doctor WHERE email=:email")
    List<Doctor> getDoctorByEmail(String email);

}
