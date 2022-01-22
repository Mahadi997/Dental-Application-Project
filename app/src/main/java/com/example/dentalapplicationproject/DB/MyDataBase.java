package com.example.dentalapplicationproject.DB;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.dentalapplicationproject.R;

@Database(entities = {User.class,Doctor.class,Appointments.class}, version = 3, exportSchema = false)
public abstract class MyDataBase extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract DoctorDao doctorDao();
    public abstract AppointmentsDao appointmentsDao();

    private static MyDataBase instance;


    //Implementing singleton pattern for database instance
    public static synchronized MyDataBase getInstance(Context context) {

        if (null == instance) {

            instance = Room.databaseBuilder(context.getApplicationContext(), MyDataBase.class, "MyDataBase")


                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }







}
