package com.example.dentalapplicationproject.RecyclerViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dentalapplicationproject.DB.Appointments;
import com.example.dentalapplicationproject.DB.User;
import com.example.dentalapplicationproject.R;
import com.example.dentalapplicationproject.ViewHolders.ApprovedAppointmentsViewHolder;

import java.util.List;


public class AdminApprovedAppointmentsRecyclerViewAdapter extends RecyclerView.Adapter<ApprovedAppointmentsViewHolder> {

    private List<Appointments> appointmentsList;
    private List<User> userList;

    public AdminApprovedAppointmentsRecyclerViewAdapter(List<Appointments> appointmentsList, List<User> userList) {
        this.appointmentsList = appointmentsList;
        this.userList = userList;
    }

    @NonNull
    @Override
    public ApprovedAppointmentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.admin_manage_appointments_card_view_layout, parent, false);
        ApprovedAppointmentsViewHolder approvedAppointmentsViewHolder = new ApprovedAppointmentsViewHolder(view);

        return approvedAppointmentsViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ApprovedAppointmentsViewHolder holder, int position) {

        holder.getAdminAppointmentDate().setText(appointmentsList.get(position).getS_day() + ", " + String.valueOf(appointmentsList.get(position).getDay()) + "/" + String.valueOf(appointmentsList.get(position).getMonth()) + "/" + String.valueOf(appointmentsList.get(position).getYear()) + " at " + appointmentsList.get(position).getTime());
        holder.getAdminAppointmentImage().setImageResource(R.drawable.clockk);
        holder.getAdminAppointmentStatus().setText("Status: " + appointmentsList.get(position).getStatus());
        holder.getAdminShowUserFirstNameAndLastName().setText(getUserFirstAndLastName(appointmentsList.get(position).getUserId()));



    }

    @Override
    public int getItemCount() {
        return appointmentsList.size();
    }

    private String getUserFirstAndLastName(int userId){
        for (User user: userList){


            if (user.getId() == userId){

                return "User:  " + user.getFirstName() + "  " + user.getLastName();

            }

        }

        return  null;
    }

}
