package com.example.dentalapplicationproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CardView appointmentCard;
    CardView doctorsCard;
    CardView ourWorkCard;
    CardView locationCard;
    CardView settingsCard;
    CardView logoutCard;
    private int userId;
    private TextView mainUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appointmentCard = findViewById(R.id.appointmentCard);
        doctorsCard = findViewById(R.id.doctorsCard);
        ourWorkCard = findViewById(R.id.ourWorkCard);
        locationCard = findViewById(R.id.locationCard);
        settingsCard = findViewById(R.id.settingsCard);
        logoutCard = findViewById(R.id.logoutCard);
        userId = getIntent().getIntExtra("id", 0);


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
                startActivity(intent);
            }
        });
locationCard.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this,GoogleMapsActivity.class);
        startActivity(intent);
    }
});
    }


}