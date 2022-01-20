package com.example.dentalapplicationproject.ViewHolders;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dentalapplicationproject.R;

public class AppointmentsViewHolder extends RecyclerView.ViewHolder{


    private TextView cardAppointmentInfo;
    private TextView cardStatus;
    private ImageView cardAppointmentsImage;


    public AppointmentsViewHolder(@NonNull View itemView) {
        super(itemView);

        cardAppointmentInfo = itemView.findViewById(R.id.cardAppointmentInfo);
        cardAppointmentsImage= itemView.findViewById(R.id.cardAppointmentsImage);
cardStatus = itemView.findViewById(R.id.cardStatus);

    }


    public TextView getCardAppointmentInfo() {
        return cardAppointmentInfo;
    }

    public ImageView getCardAppointmentsImage() {
        return cardAppointmentsImage;
    }

    public TextView getCardStatus() {
        return cardStatus;
    }
}
