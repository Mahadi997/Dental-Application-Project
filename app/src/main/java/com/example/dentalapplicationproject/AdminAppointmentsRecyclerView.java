package com.example.dentalapplicationproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dentalapplicationproject.DB.Appointments;
import com.example.dentalapplicationproject.DB.MyDataBase;
import com.example.dentalapplicationproject.RecyclerViewAdapter.AppointmentsRecyclerViewAdapter;

import java.util.List;

public class AdminAppointmentsRecyclerView extends AppCompatActivity {


    private RecyclerView appointmentsRecyclerView;
    private List<Appointments> appointmentsList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments_recycler_view);


        appointmentsRecyclerView = findViewById(R.id.appointmentsRecyclerView);
        appointmentsRecyclerView.setAdapter(new AppointmentsRecyclerViewAdapter(getAllAppointments()));
        appointmentsRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));



    }

    private List<Appointments> getAllAppointments() {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        appointmentsList = myDataBase.appointmentsDao().getAllAppointments();

        return appointmentsList;
    }



}
