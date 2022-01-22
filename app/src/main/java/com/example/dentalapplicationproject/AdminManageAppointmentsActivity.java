package com.example.dentalapplicationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dentalapplicationproject.DB.Appointments;
import com.example.dentalapplicationproject.DB.MyDataBase;

import java.util.List;

public class AdminManageAppointmentsActivity extends AppCompatActivity {

    private TextView adminShowNameSurname;
    private TextView adminShowDareAndTime;
    private TextView adminShowStatus;
    private EditText adminSetTime;
    private EditText adminSetStatus;
    private Button adminConfirmAppointment;
    private int userId;
    private int appointmentId;
    private List<Appointments> appointmentsList;
    private String userFirstNameAndLastName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_manage_appointments);


        adminShowNameSurname = findViewById(R.id.adminShowNameSurname);
        adminShowDareAndTime = findViewById(R.id.adminShowDateAndTime);
        adminShowStatus = findViewById(R.id.adminShowStatus);
        adminSetTime = findViewById(R.id.adminSetTime);
        adminSetStatus = findViewById(R.id.adminSetStatus);
        adminConfirmAppointment = findViewById(R.id.adminConfirmAppointment);


        userFirstNameAndLastName = getIntent().getStringExtra("userFirstNameAndLastName");
        userId = getIntent().getIntExtra("userId", 0);
        appointmentId = getIntent().getIntExtra("appointmentId", 0);


        adminShowNameSurname.setText(userFirstNameAndLastName);
        setDateAndStatus(appointmentId, userId);


        adminConfirmAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (adminSetTime.getText().toString().isEmpty() || adminSetStatus.getText().toString().isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Please enter time and status", Toast.LENGTH_SHORT).show();

                } else {


                    setTimeAndStatus(adminSetTime.getText().toString(),adminSetStatus.getText().toString());
                    Toast.makeText(getApplicationContext(), "Confirmation Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AdminManageAppointmentsActivity.this, AdminManageAppointmentsRecyclerView.class);
                    startActivity(intent);
                }

            }
        });


    }

    @SuppressLint("SetTextI18n")
    private void setDateAndStatus(int appointmentId, int userId) {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        appointmentsList = myDataBase.appointmentsDao().getAppointmentByAppointmentIdAndUserId(appointmentId, userId);


        for (Appointments appointment : appointmentsList) {


            if (appointment.getId() == appointmentId && appointment.getUserId() == userId) {

                adminShowDareAndTime.setText(appointment.getS_day() + ", " + String.valueOf(appointment.getDay()) + "/" + String.valueOf(appointment.getMonth()) + "/" + String.valueOf(appointment.getYear()) + " at " + appointment.getTime());
                adminShowStatus.setText(appointment.getStatus());


            }

        }


    }


    private void setTimeAndStatus(String time, String status) {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        appointmentsList = myDataBase.appointmentsDao().getAppointmentByAppointmentIdAndUserId(appointmentId, userId);


        for (Appointments appointment : appointmentsList) {


            if (appointment.getId() == appointmentId && appointment.getUserId() == userId) {

                appointment.setTime(time);
                appointment.setStatus(status);
                myDataBase.appointmentsDao().updateAppointment(appointment);


            }

        }


    }


}