package com.example.dentalapplicationproject.RecyclerViewAdapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dentalapplicationproject.DB.Appointments;
import com.example.dentalapplicationproject.DB.Doctor;
import com.example.dentalapplicationproject.R;
import com.example.dentalapplicationproject.ViewHolders.AppointmentsViewHolder;
import com.example.dentalapplicationproject.ViewHolders.DoctorViewHolder;

import java.util.List;

public class AppointmentsRecyclerViewAdapter extends RecyclerView.Adapter<AppointmentsViewHolder> {

    private List<Appointments> appointmentsList;
    private int userId;

    public AppointmentsRecyclerViewAdapter(List<Appointments> appointmentsList) {
        this.appointmentsList = appointmentsList;
    }

    @NonNull
    @Override
    public AppointmentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.appointments_cardview_layout, parent, false);
        AppointmentsViewHolder appointmentsViewHolder = new AppointmentsViewHolder(view);
        return appointmentsViewHolder;

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AppointmentsViewHolder holder, int position) {


        holder.getCardAppointmentInfo().setText(appointmentsList.get(position).getS_day() + ", " + String.valueOf(appointmentsList.get(position).getDay()) + "/" + String.valueOf(appointmentsList.get(position).getMonth()) + "/" + String.valueOf(appointmentsList.get(position).getYear()) + " at " + appointmentsList.get(position).getTime());
        holder.getCardAppointmentsImage().setImageResource(R.drawable.clockk);
        holder.getCardStatus().setText("Status: " + appointmentsList.get(position).getStatus());


    }

    @Override
    public int getItemCount() {
        return appointmentsList.size();
    }
}
