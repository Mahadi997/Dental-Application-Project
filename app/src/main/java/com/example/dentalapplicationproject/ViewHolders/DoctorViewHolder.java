package com.example.dentalapplicationproject.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dentalapplicationproject.R;


public class DoctorViewHolder extends RecyclerView.ViewHolder {

    private TextView cardDoctorName;
    private TextView cardDoctorDescription;
    private ImageView cardDoctorImage;


    public DoctorViewHolder(@NonNull View itemView) {
        super(itemView);

        cardDoctorName = itemView.findViewById(R.id.aName);
        cardDoctorDescription = itemView.findViewById(R.id.aSurname);
        cardDoctorImage = itemView.findViewById(R.id.aUserImage);

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
}
