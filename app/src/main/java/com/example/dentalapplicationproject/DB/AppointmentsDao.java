package com.example.dentalapplicationproject.DB;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AppointmentsDao {


    @Insert
    void insertAppointment(Appointments appointments);

    @Update
    void updateAppointment(Appointments appointments);



    @Delete
    void deleteAppointment(Appointments appointments);


    @Query("SELECT * FROM appointments")
    List<Appointments> getAllAppointments();


    @Query("SELECT * FROM appointments WHERE userId = :userId")
    List<Appointments> getAppointmentById(int userId);


    @Query("SELECT * FROM appointments WHERE id = :id AND userId = :userId")
    List<Appointments> getAppointmentByAppointmentIdAndUserId(int id, int userId);



    @Query("SELECT * FROM appointments WHERE status = :status")
    List<Appointments> getAppointmentByStatus(String status);

}
