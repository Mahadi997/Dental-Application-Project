package com.example.dentalapplicationproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.dentalapplicationproject.DB.Appointments;
import com.example.dentalapplicationproject.DB.MyDataBase;
import com.example.dentalapplicationproject.DB.User;
import com.example.dentalapplicationproject.RecyclerViewAdapter.AdminApprovedAppointmentsRecyclerViewAdapter;
import com.example.dentalapplicationproject.RecyclerViewAdapter.AdminManageAppointmentsRecyclerAdapter;

import java.util.List;

public class AdminApprovedAppointmentsRecyclerView extends AppCompatActivity {

    private List<Appointments> appointmentsList;
    private List<User> userList;
    private RecyclerView approvedAppointmentsRecyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_approved_appointments_recycler_view);

        approvedAppointmentsRecyclerView = findViewById(R.id. approvedAppointmentsRecyclerView);
        approvedAppointmentsRecyclerView.setAdapter(new AdminApprovedAppointmentsRecyclerViewAdapter(getApprovedAppointments("Approved") , getAllUsers()));
        approvedAppointmentsRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));







    }


    private List<Appointments> getApprovedAppointments(String status) {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        appointmentsList = myDataBase.appointmentsDao().getAppointmentByStatus(status);

        return appointmentsList;
    }

    private List<User> getAllUsers() {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        userList = myDataBase.userDao().getAllUsers();

        return userList;
    }

}