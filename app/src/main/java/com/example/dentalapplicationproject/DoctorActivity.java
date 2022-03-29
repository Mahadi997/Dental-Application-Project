package com.example.dentalapplicationproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DoctorActivity extends AppCompatActivity {

    CardView doctorLogoutCard;
    CardView doctorUploadPictureCard;
    CardView doctorGalleryUploadPictureCard;
    private int doctorId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        doctorLogoutCard = findViewById(R.id.doctorLogoutCard);
        doctorUploadPictureCard = findViewById(R.id.doctorUploadPictureCard);
        doctorId = getIntent().getIntExtra("id", 0);
        doctorGalleryUploadPictureCard = findViewById(R.id.doctorGalleryUploadPictureCard);

        doctorLogoutCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DoctorActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        doctorUploadPictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DoctorActivity.this, DoctorUploadPictureActivity.class);
                intent.putExtra("id", doctorId);
                startActivity(intent);

            }
        });

        doctorGalleryUploadPictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DoctorActivity.this,DoctorUploadImageFromGalleryActivity.class);
                intent.putExtra("id", doctorId);
                startActivity(intent);
            }
        });



    }
}