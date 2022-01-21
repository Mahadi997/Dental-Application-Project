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
    private List<Doctor> doctorlist;


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
        doctorlist = myDataBase.doctorDao().getAllDoctors();



            if (doctorlist.isEmpty()) {

                myDataBase.doctorDao().insertDoctor(new Doctor("Mike", "M", "Specialist", R.drawable.mike));
                myDataBase.doctorDao().insertDoctor(new Doctor("Bob", "B", "Assistant", R.drawable.bob));
                myDataBase.doctorDao().insertDoctor(new Doctor("John", "J", "Junior", R.drawable.john));
                myDataBase.doctorDao().insertDoctor(new Doctor("Caleb", "C", "Senior", R.drawable.caleb));
                myDataBase.doctorDao().insertDoctor(new Doctor("Summer", "S", "Assistant", R.drawable.summer));
                myDataBase.doctorDao().insertDoctor(new Doctor("Ashley", "A", "Junior", R.drawable.ashley));
                myDataBase.doctorDao().insertDoctor(new Doctor("Emma", "E", "Senior", R.drawable.emma));
                myDataBase.doctorDao().insertDoctor(new Doctor("Nicole", "N", "Specialist", R.drawable.nicole));

            }

        return myDataBase.doctorDao().getAllDoctors();
    }
}