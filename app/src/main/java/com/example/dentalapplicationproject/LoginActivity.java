package com.example.dentalapplicationproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dentalapplicationproject.DB.MyDataBase;
import com.example.dentalapplicationproject.DB.User;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private EditText logEmail;
    private EditText logPassword;
    private Button logLoginButton;
    private List<User> userList;
    private Button logRegisterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");

        logEmail = findViewById(R.id.logEmail);
        logPassword = findViewById(R.id.logPassword);
        logLoginButton = findViewById(R.id.logLoginBtn);
        logRegisterBtn = findViewById(R.id.logRegisterBtn);


        logLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (logEmail.getText().toString().equals("admin") && logPassword.getText().toString().equals("admin")) {

                    Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
                    startActivity(intent);

                } else if (validateEmail() && !checkIfFieldsAreEmpty() && checkIfUserExists()) {

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("id", getUserIdByEmail(logEmail.getText().toString()));
                    startActivity(intent);

                } else if (!validateEmail() && !checkIfFieldsAreEmpty()) {
                    Toast.makeText(getApplicationContext(), "Email address not valid", Toast.LENGTH_SHORT).show();
                } else if (checkIfFieldsAreEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter your email and password", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });


        logRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

    }


    private boolean validateEmail() {

        if (Patterns.EMAIL_ADDRESS.matcher(logEmail.getText().toString()).matches()) {
            return true;
        }

        return false;

    }

    private boolean checkIfFieldsAreEmpty() {

        if (logEmail.getText().toString().isEmpty() || logPassword.getText().toString().isEmpty()) {
            return true;
        }
        return false;

    }

    private boolean checkIfUserExists() {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        userList = myDataBase.userDao().getUserByEmail(logEmail.getText().toString());

        for (User user : userList) {
            if (user.getEmail().equals(logEmail.getText().toString()) && user.getPassword().equals(logPassword.getText().toString())) {
                return true;
            }

        }
        return false;
    }


    private int getUserIdByEmail(String email) {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        userList = myDataBase.userDao().getUserByEmail(logEmail.getText().toString());

        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                return user.getId();
            }

        }
        return 0;
    }


}