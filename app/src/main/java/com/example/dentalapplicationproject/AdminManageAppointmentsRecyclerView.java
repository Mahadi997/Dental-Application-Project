package com.example.dentalapplicationproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dentalapplicationproject.DB.Appointments;
import com.example.dentalapplicationproject.DB.MyDataBase;
import com.example.dentalapplicationproject.DB.User;
import com.example.dentalapplicationproject.RecyclerViewAdapter.AdminManageAppointmentsRecyclerAdapter;

import java.util.List;

public class AdminManageAppointmentsRecyclerView extends AppCompatActivity {

    private List<Appointments> appointmentsList;
    private List<User> userList;
    private RecyclerView adminManageAppointmentsRecyclerView;
    private AdminManageAppointmentsRecyclerAdapter.RecyclerViewClickListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_manage_appointments_recycler_view);


        setOnClickListener();
        adminManageAppointmentsRecyclerView = findViewById(R.id.adminManageAppointmentsRecyclerView);
        adminManageAppointmentsRecyclerView.setAdapter(new AdminManageAppointmentsRecyclerAdapter(getAllAppointments(), listener, getAllUsers()));
        adminManageAppointmentsRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


    }

    private void setOnClickListener() {

        listener = new AdminManageAppointmentsRecyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(AdminManageAppointmentsRecyclerView.this, AdminManageAppointmentsActivity.class);
                intent.putExtra("userId", appointmentsList.get(position).getUserId());
                intent.putExtra("appointmentId", appointmentsList.get(position).getId());
                intent.putExtra("userFirstNameAndLastName", getUserFirstAndLastName(appointmentsList.get(position).getUserId()));
                startActivity(intent);
            }
        };

    }


    private List<Appointments> getAllAppointments() {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        appointmentsList = myDataBase.appointmentsDao().getAllAppointments();

        return appointmentsList;
    }

    private List<User> getAllUsers() {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        userList = myDataBase.userDao().getAllUsers();

        return userList;
    }

    private String getUserFirstAndLastName(int userId){

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        userList = myDataBase.userDao().getAllUsers();


        for (User user: userList){


            if (user.getId() == userId){

                return "User:  " + user.getFirstName() + "  " + user.getLastName();

            }

        }

        return  null;
    }


}