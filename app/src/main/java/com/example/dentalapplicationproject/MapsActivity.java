package com.example.dentalapplicationproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class MapsActivity extends AppCompatActivity {

    private int userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setTitle("Maps");

userId = getIntent().getIntExtra("id",0);

        // Initializing fragment


        Fragment fragment = new MapFragment();


        // Opening fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        myIntent.putExtra("id",userId);
        startActivityForResult(myIntent, 0);
        return true;
    }





}