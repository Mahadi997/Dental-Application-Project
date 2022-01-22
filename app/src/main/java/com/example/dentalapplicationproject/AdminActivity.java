package com.example.dentalapplicationproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.OvershootInterpolator;

public class AdminActivity extends AppCompatActivity {


    CardView adminAppointments;
    CardView adminShowUsers;
    CardView adminLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


        adminAppointments = findViewById(R.id.adminAppointments);
        adminShowUsers = findViewById(R.id.adminShowUsers);
        adminLogout = findViewById(R.id.adminLogout);


        adminAppointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminActivity.this,AdminManageAppointmentsRecyclerView.class);
                startActivity(intent);


            }
        });




        adminShowUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminActivity.this,AdminShowUserRecyclerView.class);
                startActivity(intent);

            }
        });



        adminLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });

    }
}