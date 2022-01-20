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
import com.example.dentalapplicationproject.DB.MyDataBase;

import java.lang.reflect.GenericArrayType;
import java.util.Calendar;
import java.util.List;

public class AppointmentsActivity extends AppCompatActivity {


    CalendarView calendar;
    TextView showDate;
    String selectedDate;
    Button requestAppointment;

    private int db_day;
    private int db_month;
    private int db_year;
    private int dayOfWeek;
    private String s_day;
    private List<Appointments> appointmentsList;
    int i = 0;
    int userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);

         userId = getIntent().getIntExtra("id", 0);
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

                switch (dayOfWeek) {

                    case 1:
                        s_day = "Sunday";
                        break;
                    case 2:
                        s_day = "Monday";
                        break;
                    case 3:
                        s_day = "Tuesday";
                        break;
                    case 4:
                        s_day = "Wednesday";
                        break;
                    case 5:
                        s_day = "Thursday";
                        break;
                    case 6:
                        s_day = "Friday";
                    case 7:
                        s_day = "Saturday";

                }


            }
        });



        requestAppointment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                if (dayOfWeek == 1 || dayOfWeek == 7) {

                    Toast.makeText(getApplicationContext(), "We don't work on weekends !", Toast.LENGTH_SHORT).show();
                } else if (db_day != 0 || db_month != 0 || db_year != 0) {

                    initializeTheList();



                    Appointments appointments = new Appointments(userId, db_day, s_day, db_month + 1, db_year, "Pending","");
                    addAppointment(appointments);
                    Toast.makeText(getApplicationContext(), "Appointed added to my appointments", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(AppointmentsActivity.this, MainActivity.class);
                    intent.putExtra("appointmentId", getAppointmentId(userId, db_day, db_month, db_year, s_day));
                    intent.putExtra("id",userId);

                    startActivity(intent);


                } else {
                    Toast.makeText(getApplicationContext(), "No Date Selected", Toast.LENGTH_SHORT).show();


                }


            }
        });


    }

    private void addAppointment(Appointments appointment) {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        myDataBase.appointmentsDao().insertAppointment(appointment);

    }


    private int getAppointmentId(int userId, int db_day, int db_month, int db_year, String s_day) {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        appointmentsList = myDataBase.appointmentsDao().getAllAppointments();


        for (Appointments appointment : appointmentsList) {


            if (appointment.getUserId() == userId) {

                return appointment.getId();
            }

        }

        return 0;
    }

    private void initializeTheList() {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        appointmentsList = myDataBase.appointmentsDao().getAllAppointments();

    }


}