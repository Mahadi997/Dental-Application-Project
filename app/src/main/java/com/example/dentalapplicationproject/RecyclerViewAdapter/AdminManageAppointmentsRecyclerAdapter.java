package com.example.dentalapplicationproject.RecyclerViewAdapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dentalapplicationproject.DB.Appointments;
import com.example.dentalapplicationproject.DB.MyDataBase;
import com.example.dentalapplicationproject.DB.User;
import com.example.dentalapplicationproject.R;

import java.util.List;

public class AdminManageAppointmentsRecyclerAdapter extends RecyclerView.Adapter<AdminManageAppointmentsRecyclerAdapter.AdminManageAppointmentsViewHolder> {

    private List<Appointments> appointmentsList;
    private RecyclerViewClickListener listener;
    private List<User> userList;

    public AdminManageAppointmentsRecyclerAdapter(List<Appointments> appointmentsList, RecyclerViewClickListener listener, List<User> userList) {
        this.appointmentsList = appointmentsList;
        this.listener = listener;
        this.userList = userList;
    }


    public class AdminManageAppointmentsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView adminAppointmentDate;
        private TextView adminAppointmentStatus;
        private ImageView adminAppointmentImage;
        private TextView adminShowUserFirstNameAndLastName;


        public AdminManageAppointmentsViewHolder(@NonNull View itemView) {
            super(itemView);

            adminAppointmentDate = itemView.findViewById(R.id.adminAppointmentDate);
            adminAppointmentStatus = itemView.findViewById(R.id.adminAppointmentStatus);
            adminAppointmentImage = itemView.findViewById(R.id.adminAppointmentImage);
            adminShowUserFirstNameAndLastName = itemView.findViewById(R.id. adminShowUserFirstNameAndLastName);
            itemView.setOnClickListener(this);


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

        @Override
        public void onClick(View v) {

            listener.onClick(v, getAdapterPosition());

        }
    }


    @NonNull
    @Override
    public AdminManageAppointmentsRecyclerAdapter.AdminManageAppointmentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.admin_manage_appointments_card_view_layout, parent, false);
        AdminManageAppointmentsViewHolder adminManageAppointmentsViewHolder = new AdminManageAppointmentsViewHolder(view);
        return adminManageAppointmentsViewHolder;


    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AdminManageAppointmentsRecyclerAdapter.AdminManageAppointmentsViewHolder holder, int position) {

        holder.getAdminAppointmentDate().setText(appointmentsList.get(position).getS_day() + ", " + String.valueOf(appointmentsList.get(position).getDay()) + "/" + String.valueOf(appointmentsList.get(position).getMonth()) + "/" + String.valueOf(appointmentsList.get(position).getYear()) + " at " + appointmentsList.get(position).getTime());
        holder.getAdminAppointmentImage().setImageResource(R.drawable.clockk);
        holder.getAdminAppointmentStatus().setText("Status: " + appointmentsList.get(position).getStatus());
        holder.getAdminShowUserFirstNameAndLastName().setText(getUserFirstAndLastName(appointmentsList.get(position).getUserId()));
    }

    @Override
    public int getItemCount() {
        return appointmentsList.size();
    }


    public interface RecyclerViewClickListener {

        void onClick(View view, int position);

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







