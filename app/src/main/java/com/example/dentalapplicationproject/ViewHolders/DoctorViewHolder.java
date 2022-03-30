package com.example.dentalapplicationproject.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dentalapplicationproject.R;


public class DoctorViewHolder extends RecyclerView.ViewHolder {

    private TextView cardDoctorName;
    private TextView cardDoctorDescription;
    private ImageView cardDoctorImage;
    ConstraintLayout doctorRow;


    public DoctorViewHolder(@NonNull View itemView) {
        super(itemView);

        cardDoctorName = itemView.findViewById(R.id.adminAppointmentsNameSurname);
        cardDoctorDescription = itemView.findViewById(R.id.aSurname);
        cardDoctorImage = itemView.findViewById(R.id.aUserImage);
doctorRow = itemView.findViewById(R.id.doctorRow);
    }

    public TextView getCardDoctorName() {
        return cardDoctorName;
    }

    public TextView getCardDoctorDescription() {
        return cardDoctorDescription;
    }

    public ImageView getCardDoctorImage() {
        return cardDoctorImage;
    }

    public ConstraintLayout getDoctorRow() {
        return doctorRow;
    }
}
