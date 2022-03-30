package com.example.dentalapplicationproject.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dentalapplicationproject.R;

public class OurWorkViewHolder extends RecyclerView.ViewHolder{
    private TextView workDoctorNameAndSurname;
    private ImageView ourWorkImage;


    public OurWorkViewHolder(@NonNull View itemView) {

        super(itemView);

        workDoctorNameAndSurname = itemView.findViewById(R.id.workDoctorNameAndSurname);
        ourWorkImage = itemView.findViewById(R.id.ourWorkImage);


    }

    public TextView getWorkDoctorNameAndSurname() {
        return workDoctorNameAndSurname;
    }

    public ImageView getOurWorkImage() {
        return ourWorkImage;
    }
}
