package com.example.dentalapplicationproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.dentalapplicationproject.DB.Doctor;
import com.example.dentalapplicationproject.DB.MyDataBase;
import com.example.dentalapplicationproject.RecyclerViewAdapter.DoctorRecyclerViewAdapter;

import java.util.List;

public class DoctorRecyclerView extends AppCompatActivity {

    private RecyclerView doctorRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_recycler_view);
        doctorRecyclerView = findViewById(R.id.doctorRecyclerView);
        doctorRecyclerView.setAdapter(new DoctorRecyclerViewAdapter(getAllDoctors()));
        doctorRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    private List<Doctor> getAllDoctors() {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        myDataBase.doctorDao().insertDoctor(new Doctor("Faris","Ramic","Junior",R.drawable.settings));
        myDataBase.doctorDao().insertDoctor(new Doctor("Adnan","Mekic","Medior",R.drawable.appointment));
        myDataBase.doctorDao().insertDoctor(new Doctor("Faris","Ramic","Junior",R.drawable.logout));
        myDataBase.doctorDao().insertDoctor(new Doctor("Adnan","Mekic","Medior",R.drawable.appointment));
        myDataBase.doctorDao().insertDoctor(new Doctor("Faris","Ramic","Junior",R.drawable.settings));
        myDataBase.doctorDao().insertDoctor(new Doctor("Adnan","Mekic","Medior",R.drawable.appointment));
        myDataBase.doctorDao().insertDoctor(new Doctor("Faris","Ramic","Junior",R.drawable.settings));
        myDataBase.doctorDao().insertDoctor(new Doctor("Adnan","Mekic","Medior",R.drawable.appointment));
        return myDataBase.doctorDao().getAllDoctors();
    }
}