package com.example.dentalapplicationproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CardView appointmentCard;
    CardView doctorsCard;
    CardView myAppointmentCard;
    CardView locationCard;
    CardView settingsCard;
    CardView logoutCard;
    private int userId;
    private TextView mainUserId;
    private int appointmentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appointmentCard = findViewById(R.id.adminAppointments);
        doctorsCard = findViewById(R.id.adminShowUsers);
        myAppointmentCard = findViewById(R.id.myAppointmentsCard);
        locationCard = findViewById(R.id.locationCard);
        settingsCard = findViewById(R.id.settingsCard);
        logoutCard = findViewById(R.id.logoutCard);
        userId = getIntent().getIntExtra("id", 0);
        appointmentId = getIntent().getIntExtra("appointmentId",0);




        appointmentCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,AppointmentsActivity.class);
                intent.putExtra("id",userId);

                startActivity(intent);
            }
        });


        myAppointmentCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,AppointmentsRecyclerView.class);
                intent.putExtra("id",userId);
                intent.putExtra("appointmentId",appointmentId);
                startActivity(intent);

            }
        });

        logoutCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });


        settingsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                intent.putExtra("id", userId);
                startActivity(intent);
            }
        });

        doctorsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, DoctorRecyclerView.class);
                intent.putExtra("id", userId);
                startActivity(intent);
            }
        });
locationCard.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
        intent.putExtra("id", userId);
        startActivity(intent);

    }
});
    }


}