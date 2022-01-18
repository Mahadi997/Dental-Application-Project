package com.example.dentalapplicationproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.utils.ViewSpline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dentalapplicationproject.DB.Appointments;

import java.lang.reflect.GenericArrayType;
import java.util.Calendar;

public class AppointmentsActivity extends AppCompatActivity {


    CalendarView calendar;
    TextView showDate;
    String selectedDate;
    Button requestAppointment;

    private int db_day;
    private int db_month;
    private int db_year;
    private int dayOfWeek;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);

userId = getIntent().getIntExtra("id",0);
        calendar = findViewById(R.id.calendar);
        showDate = findViewById(R.id.showDate);
        requestAppointment = findViewById(R.id.requestAppointment);


        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {

                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMonth);

                selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                showDate.setText(selectedDate);


                db_day = dayOfMonth;
                db_month = month;
                db_year = year;
                dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            }
        });


        requestAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (dayOfWeek == 1 || dayOfWeek == 7) {

                    Toast.makeText(getApplicationContext(), "We don't work on weekends !", Toast.LENGTH_SHORT).show();
                } else if (db_day != 0 || db_month != 0 || db_year != 0) {

                    Appointments appointments = new Appointments(userId,db_day,db_month,db_year,"Pending");
                    Toast.makeText(getApplicationContext(), "Appointed requested for selected date, you will get an notification for your appointment", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(AppointmentsActivity.this,MainActivity.class);
                    startActivity(intent);
                }

                else{
                    Toast.makeText(getApplicationContext(), "No Date Selected", Toast.LENGTH_SHORT).show();


                }


            }
        });


    }
}