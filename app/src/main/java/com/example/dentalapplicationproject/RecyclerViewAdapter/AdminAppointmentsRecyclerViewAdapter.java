package com.example.dentalapplicationproject.RecyclerViewAdapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dentalapplicationproject.DB.Appointments;
import com.example.dentalapplicationproject.ViewHolders.AdminAppointmentsViewHolder;

import java.util.List;

public class AdminAppointmentsRecyclerViewAdapter extends RecyclerView.Adapter<AdminAppointmentsViewHolder>{

    private List<Appointments> appointmentsList;



    @NonNull
    @Override
    public AdminAppointmentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AdminAppointmentsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
