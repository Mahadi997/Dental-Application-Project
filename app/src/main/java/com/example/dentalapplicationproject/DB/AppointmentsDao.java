package com.example.dentalapplicationproject.DB;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AppointmentsDao {


    @Insert
    void insertAppointment(Appointments appointments);


    @Query("SELECT * FROM appointments")
    List<Appointments> getAllAppointments();


    @Query("SELECT * FROM appointments WHERE userId = :userId")
    List<Appointments> getAppointmentById(int userId);


}
