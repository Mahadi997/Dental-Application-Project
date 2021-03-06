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

import com.example.dentalapplicationproject.DB.Appointments;
import com.example.dentalapplicationproject.DB.Doctor;
import com.example.dentalapplicationproject.DB.MyDataBase;
import com.example.dentalapplicationproject.RecyclerViewAdapter.AppointmentsRecyclerViewAdapter;

import java.util.List;

public class AppointmentsRecyclerView extends AppCompatActivity {

    private RecyclerView appointmentsRecyclerView;
    private List<Appointments> appointmentsList;
    private int userId;
    private int appointmentId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments_recycler_view);
        setTitle("Appointments");
        userId = getIntent().getIntExtra("id",0);
        appointmentId = getIntent().getIntExtra("appointmentId",0);
        appointmentsRecyclerView = findViewById(R.id.appointmentsRecyclerView);
        appointmentsRecyclerView.setAdapter(new AppointmentsRecyclerViewAdapter(getAppointmentsById(userId)));
        appointmentsRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#009688"));
        actionBar.setBackgroundDrawable(colorDrawable);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        myIntent.putExtra("id",userId);
        startActivityForResult(myIntent, 0);
        return true;
    }


    private List<Appointments> getAppointmentsById(int userId) {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        appointmentsList = myDataBase.appointmentsDao().getAppointmentById(userId);

        return appointmentsList;
    }



}