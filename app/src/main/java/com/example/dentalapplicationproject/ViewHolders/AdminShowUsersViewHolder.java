package com.example.dentalapplicationproject.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dentalapplicationproject.R;

import java.nio.FloatBuffer;

public class AdminShowUsersViewHolder extends RecyclerView.ViewHolder{

    private TextView aFirstName;
    private TextView aLastName;

    private ImageView aUserImage;




    public AdminShowUsersViewHolder(@NonNull View itemView) {
        super(itemView);

        aUserImage = itemView.findViewById(R.id.aUserImage);
        aFirstName = itemView.findViewById(R.id.aFirstName);
        aLastName = itemView.findViewById(R.id.aLastName);


    }

    public TextView getaFirstName() {
        return aFirstName;
    }

    public TextView getaLastName() {
        return aLastName;
    }



    public ImageView getaUserImage() {
        return aUserImage;
    }
}
