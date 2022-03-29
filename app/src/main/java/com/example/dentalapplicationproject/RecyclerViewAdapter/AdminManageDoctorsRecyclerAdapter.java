package com.example.dentalapplicationproject.RecyclerViewAdapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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

import com.example.dentalapplicationproject.AdminShowDoctorsRecyclerView;
import com.example.dentalapplicationproject.AdminShowUsersRecyclerView;
import com.example.dentalapplicationproject.DB.Doctor;
import com.example.dentalapplicationproject.DB.MyDataBase;
import com.example.dentalapplicationproject.DB.User;
import com.example.dentalapplicationproject.R;

import java.util.List;

public class AdminManageDoctorsRecyclerAdapter extends RecyclerView.Adapter<AdminManageDoctorsRecyclerAdapter.ViewHolder> {

    Context context;
    List<Doctor> doctorList;
    List<Doctor> myDoctorList;
    List<Doctor> deleteDoctorList;
    EditText updateDoctorDialogFirstname;
    EditText updateDoctorDialogLastname;
    EditText updateDoctorDialogDescription;
    EditText updateDoctorDialogEmail;
    EditText updateDoctorDialogPassword;
    Button updateDialogAddDoctorBtn;
    String currentDoctorEmail;


    public AdminManageDoctorsRecyclerAdapter(Context context, List<Doctor> doctorList) {
        this.context = context;
        this.doctorList = doctorList;
    }

    @NonNull
    @Override
    public AdminManageDoctorsRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.admin_show_doctors_row, parent, false);
        AdminManageDoctorsRecyclerAdapter.ViewHolder viewHolder = new AdminManageDoctorsRecyclerAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdminManageDoctorsRecyclerAdapter.ViewHolder holder, int position) {

        holder.getAdminDoctorImage().setImageResource(R.drawable.dentist);
        holder.getAdminDoctorNameAndSurname().setText(getDoctorFirstAndLastName(doctorList.get(position).getId()));

        holder.getDoctorRow().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.update_doctor_dialog);
                dialog.show();

                updateDoctorDialogFirstname = dialog.findViewById(R.id.updateDoctorDialogFirstname);
                updateDoctorDialogLastname = dialog.findViewById(R.id.updateDoctorDialogLastname);
                updateDoctorDialogDescription = dialog.findViewById(R.id.updateDoctorDialogDescription);
                updateDoctorDialogEmail = dialog.findViewById(R.id.updateDoctorDialogEmail);
                updateDoctorDialogPassword = dialog.findViewById(R.id.updateDoctorDialogPassword);
                updateDialogAddDoctorBtn = dialog.findViewById(R.id.updateDialogAddDoctorBtn);


                updateDoctorDialogFirstname.setText(doctorList.get(holder.getAdapterPosition()).getName());
                updateDoctorDialogLastname.setText(doctorList.get(holder.getAdapterPosition()).getSurname());
                updateDoctorDialogDescription.setText(doctorList.get(holder.getAdapterPosition()).getDescription());
                updateDoctorDialogEmail.setText(doctorList.get(holder.getAdapterPosition()).getEmail());
                updateDoctorDialogPassword.setText(doctorList.get(holder.getAdapterPosition()).getPassword());

                updateDialogAddDoctorBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (!updateDoctorDialogFirstname.getText().toString().isEmpty() && !updateDoctorDialogLastname.getText().toString().isEmpty() && !updateDoctorDialogDescription.getText().toString().isEmpty() && !updateDoctorDialogEmail.getText().toString().isEmpty() && !updateDoctorDialogPassword.getText().toString().isEmpty()) {

                            myDoctorList = getAllDoctors();
                            currentDoctorEmail = myDoctorList.get(holder.getAdapterPosition()).getEmail();
                            updateDoctor(currentDoctorEmail, updateDoctorDialogFirstname.getText().toString(), updateDoctorDialogLastname.getText().toString(),updateDoctorDialogDescription.getText().toString(),updateDoctorDialogEmail.getText().toString(),updateDoctorDialogPassword.getText().toString());
                            Toast.makeText(context, "Doctor Updated Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(context.getApplicationContext(), AdminShowDoctorsRecyclerView.class);
                            context.startActivity(intent);

                        }
                        else{

                            Toast.makeText(context, "Please fill all the fields !", Toast.LENGTH_SHORT).show();

                        }

                    }
                });

            }
        });

        holder.getDoctorRow().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {


                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Doctor")
                        .setMessage("Are you sure you want to delete the doctor ? ")
                        .setIcon(R.drawable.delete)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                myDoctorList = getAllDoctors();
                                currentDoctorEmail = myDoctorList.get(holder.getAdapterPosition()).getEmail();
                                deleteDoctor(currentDoctorEmail);
                                notifyItemRemoved(holder.getAdapterPosition());
                                Toast.makeText(context, "Doctor Deleted Successfully !", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(context.getApplicationContext(), AdminShowDoctorsRecyclerView.class);
                                context.startActivity(intent);


                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent intent = new Intent(context.getApplicationContext(), AdminShowDoctorsRecyclerView.class);
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
        return doctorList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView adminDoctorImage;
        TextView adminDoctorNameAndSurname;
        ConstraintLayout doctorRow;


        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            adminDoctorImage = itemView.findViewById(R.id.adminDoctorImage);
            adminDoctorNameAndSurname = itemView.findViewById(R.id.adminDoctorNameAndSurname);
            doctorRow = itemView.findViewById(R.id.doctorRow);

        }

        public ImageView getAdminDoctorImage() {
            return adminDoctorImage;
        }

        public TextView getAdminDoctorNameAndSurname() {
            return adminDoctorNameAndSurname;
        }

        public ConstraintLayout getDoctorRow() {
            return doctorRow;
        }
    }


    private String getDoctorFirstAndLastName(int doctorId) {
        for (Doctor doctor : doctorList) {


            if (doctor.getId() == doctorId) {

                return "Doctor:  " + doctor.getName() + "  " + doctor.getSurname();

            }

        }

        return null;
    }


    List<Doctor> getAllDoctors() {

        MyDataBase myDataBase = MyDataBase.getInstance(context.getApplicationContext());
        doctorList = myDataBase.doctorDao().getAllDoctors();
        return doctorList;
    }


    private void updateDoctor(String currentDoctorEmail, String fName, String lName, String description, String email, String password) {

        MyDataBase myDataBase = MyDataBase.getInstance(context.getApplicationContext());
        doctorList = myDataBase.doctorDao().getDoctorByEmail(currentDoctorEmail);

        for (Doctor doctor : doctorList) {

            doctor.setName(fName);
            doctor.setSurname(lName);
            doctor.setDescription(description);
            doctor.setEmail(email);
            doctor.setPassword(password);
            myDataBase.doctorDao().updateDoctor(doctor);

        }


    }


    private void deleteDoctor(String email){

        MyDataBase myDataBase = MyDataBase.getInstance(context.getApplicationContext());
        deleteDoctorList =  myDataBase.doctorDao().getDoctorByEmail(email);


        for (Doctor doctor : deleteDoctorList){

            myDataBase.doctorDao().deleteDoctor(doctor);

        }

    }

}
