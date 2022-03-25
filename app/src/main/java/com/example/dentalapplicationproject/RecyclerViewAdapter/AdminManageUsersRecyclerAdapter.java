package com.example.dentalapplicationproject.RecyclerViewAdapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dentalapplicationproject.DB.User;
import com.example.dentalapplicationproject.R;

import java.util.List;

public class AdminManageUsersRecyclerAdapter extends RecyclerView.Adapter<AdminManageUsersRecyclerAdapter.ViewHolder> {

    Context context;
    List<User> userList;

    public AdminManageUsersRecyclerAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.admin_show_users_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.getAdminUserImage().setImageResource(R.drawable.mann);
        holder.getAdminUserNameAndSurname().setText(getUserFirstAndLastName(userList.get(position).getId()));

holder.getUserRow().setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {




        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.update_user_dialog);


    }
});

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView adminUserImage;
        TextView adminUserNameAndSurname;
        ConstraintLayout userRow;


        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            adminUserImage = itemView.findViewById(R.id.adminUserImage);
            adminUserNameAndSurname = itemView.findViewById(R.id.adminUserNameAndSurname);
            userRow = itemView.findViewById(R.id.userRow);




        }

        public ImageView getAdminUserImage() {
            return adminUserImage;
        }

        public TextView getAdminUserNameAndSurname() {
            return adminUserNameAndSurname;
        }

        public ConstraintLayout getUserRow() {
            return userRow;
        }
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
