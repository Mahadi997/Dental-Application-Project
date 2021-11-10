package com.example.dentalapplicationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dentalapplicationproject.DB.MyDataBase;
import com.example.dentalapplicationproject.DB.User;

import java.util.List;

public class SettingsActivity extends AppCompatActivity {

    private EditText settingsOldPassword;
    private EditText settingsNewPassword;
    private EditText settingsReNewPassword;
    private Button settingsConfirmBtn;
    private List<User> userList;
    private int userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        settingsOldPassword = findViewById(R.id.settingsOldPassword);
        settingsNewPassword = findViewById(R.id.settingsNewPassword);
        settingsReNewPassword = findViewById(R.id.settingsRePassword);
        settingsConfirmBtn = findViewById(R.id.settingsConfirmBtn);
        userId = getIntent().getIntExtra("id", 0);

        settingsConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkIfOldPasswordMatch() && checkIfTheNewPasswordsMatch() & !checkIfFieldsAreEmpty()) {

                    updateUserPassword();
                    Toast.makeText(getApplicationContext(), "Password changed successfully ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else if (checkIfFieldsAreEmpty()) {

                    Toast.makeText(getApplicationContext(), "Please fill all the fields", Toast.LENGTH_SHORT).show();

                } else if (checkIfOldPasswordMatch() && !checkIfTheNewPasswordsMatch()) {

                    Toast.makeText(getApplicationContext(), "Your new passwords don't match", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), "Your current password doesn't match", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    private boolean checkIfOldPasswordMatch() {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        userList = myDataBase.userDao().getUserById(userId);

        for (User user : userList) {

            if (user.getPassword().equals(settingsOldPassword.getText().toString())) {
                return true;
            }

        }

        return false;
    }

    private boolean checkIfTheNewPasswordsMatch() {

        if (settingsNewPassword.getText().toString().equals(settingsReNewPassword.getText().toString())) {
            return true;
        }

        return false;
    }

    private boolean checkIfFieldsAreEmpty() {
        if (settingsOldPassword.getText().toString().isEmpty() || settingsNewPassword.getText().toString().isEmpty() || settingsReNewPassword.getText().toString().isEmpty()) {
            return true;
        }

        return false;
    }

    private void updateUserPassword() {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        userList = myDataBase.userDao().getUserById(userId);

        for (User user : userList){
            user.setPassword(settingsNewPassword.getText().toString());
            myDataBase.userDao().updateUser(user);

        }


    }


}