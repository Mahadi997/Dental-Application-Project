package com.example.dentalapplicationproject.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dentalapplicationproject.R;

public class ApprovedAppointmentsViewHolder extends RecyclerView.ViewHolder{

    private TextView adminAppointmentDate;
    private TextView adminAppointmentStatus;
    private ImageView adminAppointmentImage;
    private TextView adminShowUserFirstNameAndLastName;


    public ApprovedAppointmentsViewHolder(@NonNull View itemView) {
        super(itemView);

        adminAppointmentDate = itemView.findViewById(R.id.adminAppointmentDate);
        adminAppointmentStatus = itemView.findViewById(R.id.adminAppointmentStatus);
        adminAppointmentImage = itemView.findViewById(R.id.adminAppointmentImage);
        adminShowUserFirstNameAndLastName = itemView.findViewById(R.id. adminShowUserFirstNameAndLastName);



    }

    public TextView getAdminAppointmentDate() {
        return adminAppointmentDate;
    }

    public TextView getAdminAppointmentStatus() {
        return adminAppointmentStatus;
    }

    public ImageView getAdminAppointmentImage() {
        return adminAppointmentImage;
    }

    public TextView getAdminShowUserFirstNameAndLastName() {
        return adminShowUserFirstNameAndLastName;
    }


}
