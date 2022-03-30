package com.example.dentalapplicationproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.dentalapplicationproject.DB.Doctor;
import com.example.dentalapplicationproject.DB.DoctorImages;
import com.example.dentalapplicationproject.DB.MyDataBase;
import com.example.dentalapplicationproject.RecyclerViewAdapter.OurWorkRecyclerViewAdapter;

import java.util.List;

public class OurWorkRecyclerView extends AppCompatActivity {

    RecyclerView ourWorkRecyclerView;
    private int userId;

    private List<DoctorImages> doctorImagesList;
    private List<Doctor> doctorList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_work_recycler_view);
        ourWorkRecyclerView = findViewById(R.id.ourWorkRecyclerView);
        userId = getIntent().getIntExtra("id", 0);
        ourWorkRecyclerView.setAdapter(new OurWorkRecyclerViewAdapter(getAllImages(), getAllDoctors()));
        ourWorkRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#009688"));
        actionBar.setBackgroundDrawable(colorDrawable);



    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        myIntent.putExtra("id", userId);
        startActivityForResult(myIntent, 0);
        return true;
    }


    List<DoctorImages> getAllImages() {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        return myDataBase.doctorImagesDao().getAllImages();

    }

    List<Doctor> getAllDoctors() {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        return myDataBase.doctorDao().getAllDoctors();


    }

}