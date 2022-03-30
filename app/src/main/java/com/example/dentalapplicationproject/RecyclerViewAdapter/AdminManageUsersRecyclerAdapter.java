package com.example.dentalapplicationproject.RecyclerViewAdapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dentalapplicationproject.AdminShowUsersRecyclerView;
import com.example.dentalapplicationproject.DB.Appointments;
import com.example.dentalapplicationproject.DB.MyDataBase;
import com.example.dentalapplicationproject.DB.User;
import com.example.dentalapplicationproject.R;

import java.util.List;

public class AdminManageUsersRecyclerAdapter extends RecyclerView.Adapter<AdminManageUsersRecyclerAdapter.ViewHolder> {

    Context context;
    List<User> deleteUserList;
    List<User> userList;
    List<User> userEmailList;
     List<User> testUserList;
     List<Appointments> deleteAppointmentList;
    String currentUserEmail;
    EditText updateDialogFirstname;
    EditText updateDialogLastname;
    EditText updateDialogCity;
    EditText updateDialogAddress;
    EditText updateDialogEmail;
    EditText updateDialogPassword;
    Button updateDialogAddUserBtn;
    int appointmentUserId;

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

        holder.getAdminUserImage().setImageResource(R.drawable.user);
        holder.getAdminUserNameAndSurname().setText(getUserFirstAndLastName(userList.get(position).getId()));

        holder.getUserRow().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.update_user_dialog);
                dialog.show();

                updateDialogFirstname = dialog.findViewById(R.id.dialogFirstname);
                updateDialogLastname = dialog.findViewById(R.id.dialogLastname);
                updateDialogCity = dialog.findViewById(R.id.dialogCity);
                updateDialogAddress = dialog.findViewById(R.id.dialogAddress);
                updateDialogEmail = dialog.findViewById(R.id.dialogEmail);
                updateDialogPassword = dialog.findViewById(R.id.dialogPassword);
                updateDialogAddUserBtn = dialog.findViewById(R.id.dialogAddUserBtn);

                updateDialogFirstname.setText(userList.get(holder.getAdapterPosition()).getFirstName());
                updateDialogLastname.setText(userList.get(holder.getAdapterPosition()).getLastName());
                updateDialogCity.setText(userList.get(holder.getAdapterPosition()).getCity());
                updateDialogAddress.setText(userList.get(holder.getAdapterPosition()).getAddress());
                updateDialogEmail.setText(userList.get(holder.getAdapterPosition()).getEmail());
                updateDialogPassword.setText(userList.get(holder.getAdapterPosition()).getPassword());


                updateDialogAddUserBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (!validateEmail()) {

                            Toast.makeText(context, "Please enter a valid email ", Toast.LENGTH_SHORT).show();

                        } else if (!updateDialogFirstname.getText().toString().isEmpty() && !updateDialogLastname.getText().toString().isEmpty() && !updateDialogCity.getText().toString().isEmpty() && !updateDialogAddress.getText().toString().isEmpty() && !updateDialogEmail.getText().toString().isEmpty() && !updateDialogPassword.getText().toString().isEmpty()) {
                            userEmailList = getAllUsers();
                            currentUserEmail = userEmailList.get(holder.getAdapterPosition()).getEmail();



                            updateUser(currentUserEmail,updateDialogFirstname.getText().toString(), updateDialogLastname.getText().toString(), updateDialogCity.getText().toString(), updateDialogAddress.getText().toString(), updateDialogEmail.getText().toString(), updateDialogPassword.getText().toString());
                            Toast.makeText(context, "User Updated Successfully !", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(context.getApplicationContext(), AdminShowUsersRecyclerView.class);
                            context.startActivity(intent);

                        }
                        else{

                            Toast.makeText(context, "Please fill all the fields !", Toast.LENGTH_SHORT).show();

                        }


                    }
                });


            }
        });


    holder.getUserRow().setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {

            AlertDialog.Builder builder = new AlertDialog.Builder(context)
                    .setTitle("Delete User")
                    .setMessage("Are you sure you want to delete the user ? ")
                    .setIcon(R.drawable.delete)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            userEmailList = getAllUsers();
                            currentUserEmail = userEmailList.get(holder.getAdapterPosition()).getEmail();
                            appointmentUserId = getUserId(currentUserEmail);
                            deleteUser(currentUserEmail);
                            deleteAppointmentByUserId(appointmentUserId);
                            notifyItemRemoved(holder.getAdapterPosition());
                            Toast.makeText(context, "User Deleted Successfully !", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(context.getApplicationContext(), AdminShowUsersRecyclerView.class);
                            context.startActivity(intent);


                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
//                            Toast.makeText(context, "User not deleted !", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(context.getApplicationContext(), AdminShowUsersRecyclerView.class);
                            context.startActivity(intent);
                        }
                    });

builder.show();

            return true;
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
            adminUserNameAndSurname = itemView.findViewById(R.id.ourWorkDoctorNameAndSurname);
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

    private String getUserFirstAndLastName(int userId) {
        for (User user : userList) {


            if (user.getId() == userId) {

                return "User:  " + user.getFirstName() + "  " + user.getLastName();

            }

        }

        return null;
    }

    List<User> getAllUsers() {

        MyDataBase myDataBase = MyDataBase.getInstance(context.getApplicationContext());
        userList = myDataBase.userDao().getAllUsers();
        return userList;
    }




    private boolean validateEmail() {

        if (Patterns.EMAIL_ADDRESS.matcher(updateDialogEmail.getText().toString()).matches()) {
            return true;
        }

        return false;

    }

    private void updateUser(String currentUserEmail, String fName, String lName, String city, String address, String email, String password) {

        MyDataBase myDataBase = MyDataBase.getInstance(context.getApplicationContext());
        userList = myDataBase.userDao().getUserByEmail(currentUserEmail);

        for (User user : userList) {

            user.setFirstName(fName);
            user.setLastName(lName);
            user.setCity(city);
            user.setAddress(address);
            user.setEmail(email);
            user.setPassword(password);
            myDataBase.userDao().updateUser(user);

        }


    }


    private void deleteUser(String email){

        MyDataBase myDataBase = MyDataBase.getInstance(context.getApplicationContext());
        deleteUserList =  myDataBase.userDao().getUserByEmail(email);


        for (User user : deleteUserList){

            myDataBase.userDao().deleteUser(user);

        }

    }


private int getUserId(String email){

    MyDataBase myDataBase = MyDataBase.getInstance(context.getApplicationContext());
   testUserList =  myDataBase.userDao().getUserByEmail(email);


   for (User user : testUserList){

       return  user.getId();

   }

    return 0;
}

private void deleteAppointmentByUserId(int userId){

    MyDataBase myDataBase = MyDataBase.getInstance(context.getApplicationContext());
    deleteAppointmentList = myDataBase.appointmentsDao().getAppointmentById(userId);

    for (Appointments appointment: deleteAppointmentList){

        myDataBase.appointmentsDao().deleteAppointment(appointment);

    }





}



}
