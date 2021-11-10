package com.example.dentalapplicationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dentalapplicationproject.DB.MyDataBase;
import com.example.dentalapplicationproject.DB.User;

import java.util.List;

public class RegistrationActivity extends AppCompatActivity {

    private EditText regFirstName;
    private EditText regLastName;
    private EditText regCity;
    private EditText regAddress;
    private EditText regEmail;
    private EditText regPassword;
    private Button regRegisterBtn;
    private List<User> userList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setTitle("Registration");

        regFirstName = findViewById(R.id.regFirstName);
        regLastName = findViewById(R.id.regLastName);
        regCity = findViewById(R.id.regCity);
        regAddress = findViewById(R.id.regAddress);
        regEmail = findViewById(R.id.regEmail);
        regPassword = findViewById(R.id.regPassword);
        regRegisterBtn = findViewById(R.id.regRegisterBtn);


        regRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (validateEmail() && !checkIfFieldsAreEmpty() && !checkIfUserExists()) {

                    User user = new User(regFirstName.getText().toString(), regLastName.getText().toString(), regCity.getText().toString(), regAddress.getText().toString(), regEmail.getText().toString(), regPassword.getText().toString());
                    MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
                    myDataBase.userDao().insertUser(user);
                    Toast.makeText(getApplicationContext(), "Registration successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegistrationActivity.this,LoginActivity.class);
                    startActivity(intent);

                }
                else if (!validateEmail() && !checkIfFieldsAreEmpty()) {
                    Toast.makeText(getApplicationContext(), "Email address not valid", Toast.LENGTH_SHORT).show();
                }
                else if (checkIfFieldsAreEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "User exists", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

    private boolean validateEmail() {

        if (Patterns.EMAIL_ADDRESS.matcher(regEmail.getText().toString()).matches()) {
            return true;
        }

        return false;

    }

    private boolean checkIfFieldsAreEmpty() {

        if (regFirstName.getText().toString().isEmpty() || regLastName.getText().toString().isEmpty() || regCity.getText().toString().isEmpty() || regAddress.getText().toString().isEmpty() || regEmail.getText().toString().isEmpty() || regPassword.getText().toString().isEmpty()) {
            return true;
        }
        return false;

    }

    private boolean checkIfUserExists() {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        userList = myDataBase.userDao().getUserByEmail(regEmail.getText().toString());

        for (User user : userList) {
            if (user.getEmail().equals(regEmail.getText().toString())) {
                return true;
            }

        }
        return false;
    }

}