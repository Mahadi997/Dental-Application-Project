package com.example.dentalapplicationproject.RecyclerViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dentalapplicationproject.DB.Appointments;
import com.example.dentalapplicationproject.DB.User;
import com.example.dentalapplicationproject.R;
import com.example.dentalapplicationproject.ViewHolders.AdminShowUsersViewHolder;
import com.example.dentalapplicationproject.ViewHolders.AppointmentsViewHolder;

import java.util.List;

public class AdminShowUsersRecyclerViewAdapter extends RecyclerView.Adapter<AdminShowUsersViewHolder>{

    private List<User> userList;

    public AdminShowUsersRecyclerViewAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public AdminShowUsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.admin_show_users_cardview_layout, parent, false);
        AdminShowUsersViewHolder adminShowUsersViewHolder = new AdminShowUsersViewHolder(view);
        return adminShowUsersViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdminShowUsersViewHolder holder, int position) {

        holder.getaUserImage().setImageResource(R.drawable.mann);
        holder.getaFirstName().setText(userList.get(position).getFirstName());
        holder.getaLastName().setText(userList.get(position).getLastName());


    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
