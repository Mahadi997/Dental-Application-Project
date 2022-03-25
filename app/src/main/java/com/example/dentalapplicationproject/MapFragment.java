package com.example.dentalapplicationproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapFragment extends Fragment {

    private GoogleMap mMap;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Initializing view

        View view = inflater.inflate(R.layout.fragment_map, container, false);


        // Initializing map fragment
        SupportMapFragment supportMapFragment = (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.google_map);

        //Async map


        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                // When map is loaded


                mMap = googleMap;


                LatLng sarajevo = new LatLng(43.81876, 18.31210); // Burch's location
                mMap.addMarker(new MarkerOptions().position(sarajevo).title("International Burch University"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sarajevo));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sarajevo, 15)); // Zooming the view for map
            }
        });


        return view;
    }
}