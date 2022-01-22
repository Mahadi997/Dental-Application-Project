package com.example.dentalapplicationproject.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dentalapplicationproject.R;

public class AdminAppointmentsViewHolder extends RecyclerView.ViewHolder {


    private TextView cardAppointmentInfo;
    private TextView cardStatus;
    private ImageView cardAppointmentsImage;




    public AdminAppointmentsViewHolder(@NonNull View itemView) {
        super(itemView);

        cardAppointmentInfo = itemView.findViewById(R.id.adminAppointmentsNameSurname);
        cardAppointmentsImage= itemView.findViewById(R.id.aUserImage);
        cardStatus = itemView.findViewById(R.id.adminAppointmentsStatus);

    }


    public TextView getCardAppointmentInfo() {
        return cardAppointmentInfo;
    }

    public TextView getCardStatus() {
        return cardStatus;
    }

    public ImageView getCardAppointmentsImage() {
        return cardAppointmentsImage;
    }
}
