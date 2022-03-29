package com.example.dentalapplicationproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dentalapplicationproject.DB.Doctor;
import com.example.dentalapplicationproject.DB.MyDataBase;

import com.example.dentalapplicationproject.DB.User;
import com.example.dentalapplicationproject.RecyclerViewAdapter.AdminManageDoctorsRecyclerAdapter;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class AdminShowDoctorsRecyclerView extends AppCompatActivity {


    RecyclerView adminShowDoctorsRecyclerView;
    List<Doctor> doctorList;
    List<Doctor> doctorrList;
    FloatingActionButton addDoctorBtn;
    EditText doctorDialogFirstname;
    EditText doctorDialogLastname;
    EditText doctorDialogDescription;
    EditText doctorDialogEmail;
    EditText doctorDialogPassword;
    Button myBtn;
    List<User> userList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_show_doctors_recycler_view);



        doctorList = getAllDoctors();


        adminShowDoctorsRecyclerView = findViewById(R.id.adminShowDoctorsRecyclerView);
        adminShowDoctorsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdminManageDoctorsRecyclerAdapter adapter = new AdminManageDoctorsRecyclerAdapter(this, doctorList);
        adminShowDoctorsRecyclerView.setAdapter(adapter);

        Dialog dialog = new Dialog(AdminShowDoctorsRecyclerView.this);
        dialog.setContentView(R.layout.add_doctor_dialog);


        addDoctorBtn = findViewById(R.id.addDoctorBtn);


        doctorDialogFirstname = dialog.findViewById(R.id.doctorDialogFirstname);
        doctorDialogLastname = dialog.findViewById(R.id.doctorDialogLastname);
        doctorDialogDescription = dialog.findViewById(R.id.doctorDialogDescription);
        doctorDialogEmail = dialog.findViewById(R.id.doctorDialogEmail);
        doctorDialogPassword = dialog.findViewById(R.id.doctorDialogPassword);
        myBtn = dialog.findViewById(R.id.myBtn);





        addDoctorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.show();

                myBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (checkIfDoctorExists()) {

                            Toast.makeText(AdminShowDoctorsRecyclerView.this, "Doctor Already Exists !", Toast.LENGTH_SHORT).show();

                        }

                        else if (checkIfDoctorEmailIsTheSameAsUserEmail()){

                            Toast.makeText(AdminShowDoctorsRecyclerView.this, "System user is using this email !", Toast.LENGTH_SHORT).show();

                        }

                        else if (!doctorDialogFirstname.getText().toString().isEmpty() && !doctorDialogLastname.getText().toString().isEmpty() && !doctorDialogDescription.getText().toString().isEmpty() && !doctorDialogEmail.getText().toString().isEmpty() && !doctorDialogPassword.getText().toString().isEmpty()) {

                            Doctor doctor = new Doctor(doctorDialogFirstname.getText().toString(), doctorDialogLastname.getText().toString(), doctorDialogDescription.getText().toString(), doctorDialogEmail.getText().toString(), doctorDialogPassword.getText().toString());
                            addDoctor(doctor);
                            doctorList = getAllDoctors();
                            adapter.notifyItemInserted(doctorList.size() - 1);
                            Toast.makeText(AdminShowDoctorsRecyclerView.this, "Doctor Added Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(AdminShowDoctorsRecyclerView.this, AdminShowDoctorsRecyclerView.class);
                            startActivity(intent);

                        }
                        else {

                            Toast.makeText(AdminShowDoctorsRecyclerView.this, "Please fill all the fields or change Doctor email", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }

        });


    }


    List<Doctor> getAllDoctors() {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        doctorList = myDataBase.doctorDao().getAllDoctors();
        return doctorList;
    }

    private boolean checkIfDoctorExists() {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        doctorrList = myDataBase.doctorDao().getDoctorByEmail(doctorDialogEmail.getText().toString());

        for (Doctor doctor : doctorrList) {
            if (doctor.getEmail().equals(doctorDialogEmail.getText().toString())) {
                return true;
            }

        }
        return false;
    }

    private void addDoctor(Doctor doctor) {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        myDataBase.doctorDao().insertDoctor(doctor);

    }

    private boolean checkIfDoctorEmailIsTheSameAsUserEmail(){

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        userList = myDataBase.userDao().getUserByEmail(doctorDialogEmail.getText().toString());


        if (userList.isEmpty()){

            return false;

        }

        else {

            return true;
        }

    }


}