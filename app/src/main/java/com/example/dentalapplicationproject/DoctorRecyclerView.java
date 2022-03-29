package com.example.dentalapplicationproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.dentalapplicationproject.DB.Doctor;
import com.example.dentalapplicationproject.DB.MyDataBase;
import com.example.dentalapplicationproject.RecyclerViewAdapter.DoctorRecyclerViewAdapter;

import java.util.List;

public class DoctorRecyclerView extends AppCompatActivity {

    private RecyclerView doctorRecyclerView;
    private List<Doctor> doctorlist;
    private int userId;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_recycler_view);
        setTitle("Our Doctors");
        userId = getIntent().getIntExtra("id",0);
        doctorRecyclerView = findViewById(R.id.doctorRecyclerView);
        doctorRecyclerView.setAdapter(new DoctorRecyclerViewAdapter(getAllDoctors()));
        doctorRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));





    }
@Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        myIntent.putExtra("id",userId);
        startActivityForResult(myIntent, 0);
        return true;
    }


    private List<Doctor> getAllDoctors() {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        doctorlist = myDataBase.doctorDao().getAllDoctors();




        return myDataBase.doctorDao().getAllDoctors();
    }
}