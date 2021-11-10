package com.example.dentalapplicationproject.RecyclerViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dentalapplicationproject.DB.Doctor;
import com.example.dentalapplicationproject.R;
import com.example.dentalapplicationproject.ViewHolders.DoctorViewHolder;

import java.util.List;

public class DoctorRecyclerViewAdapter extends RecyclerView.Adapter<DoctorViewHolder> {

    private List<Doctor> doctorList;

    public DoctorRecyclerViewAdapter(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    @NonNull
    @Override
    public DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.doctor_cardview_layout, parent, false);
        DoctorViewHolder doctorViewHolder = new DoctorViewHolder(view);
        return doctorViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorViewHolder holder, int position) {

        holder.getCardDoctorName().setText(doctorList.get(position).getName());
        holder.getCardDoctorDescription().setText(doctorList.get(position).getDescription());
        holder.getCardDoctorImage().setImageResource(doctorList.get(position).getImage());


    }

    @Override
    public int getItemCount() {
        return doctorList.size();
    }
}
