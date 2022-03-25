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
    CardView adminApprovedAppointments;
    CardView adminShowDoctors;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


        adminAppointments = findViewById(R.id.adminAppointments);
        adminShowUsers = findViewById(R.id.adminShowUsers);
        adminLogout = findViewById(R.id.adminLogout);
        adminApprovedAppointments = findViewById(R.id.adminApprovedAppointments);
        adminShowDoctors = findViewById(R.id.adminShowDoctors);


        adminAppointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminActivity.this,AdminManageAppointmentsRecyclerView.class);
                startActivity(intent);


            }
        });

adminApprovedAppointments.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


       Intent intent = new Intent(AdminActivity.this,AdminApprovedAppointmentsRecyclerView.class);
       startActivity(intent);
 }
});

////////////////////////////////////////////////////////////////////////////////////////////////////


        adminShowUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(AdminActivity.this,AdminShowUsersRecyclerView.class);
                startActivity(intent);



            }
        });



        adminShowDoctors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


////////////////////////////////////////////////////////////////////////////////////////////////////


        adminLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });

    }
}