package com.example.dentalapplicationproject.DB;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AppointmentsDao {


    @Query("SELECT * FROM appointments")
    List<Appointments> getAllAppointments();


    @Query("SELECT * FROM appointments WHERE userId = :userId")
    List<Appointments> getAppointmentById(int userId);




}
