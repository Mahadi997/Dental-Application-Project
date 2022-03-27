package com.example.dentalapplicationproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dentalapplicationproject.DB.MyDataBase;
import com.example.dentalapplicationproject.DB.User;
import com.example.dentalapplicationproject.RecyclerViewAdapter.AdminManageUsersRecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class AdminShowUsersRecyclerView extends AppCompatActivity {


    RecyclerView adminShowUsersRecyclerView;
    List<User> userList;
    List<User> userrList;
    FloatingActionButton addUserBtn;
    EditText dialogFirstname;
    EditText dialogLastname;
    EditText dialogCity;
    EditText dialogAddress;
    EditText dialogEmail;
    EditText dialogPassword;
    Button dialogAddUserBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_show_users_recycler_view);
        userList = getAllUsers();
        adminShowUsersRecyclerView = findViewById(R.id.adminShowUsersRecyclerView);
        adminShowUsersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdminManageUsersRecyclerAdapter adapter = new AdminManageUsersRecyclerAdapter(this, userList);
        adminShowUsersRecyclerView.setAdapter(adapter);
        addUserBtn = findViewById(R.id.addUserBtn);
        Dialog dialog = new Dialog(AdminShowUsersRecyclerView.this);
        dialog.setContentView(R.layout.add_user_dialog);
        dialogFirstname = dialog.findViewById(R.id.updateDialogFirstname);
        dialogLastname = dialog.findViewById(R.id.updateDialogLastname);
        dialogCity = dialog.findViewById(R.id.updateDialogCity);
        dialogAddress = dialog.findViewById(R.id.updateDialogAddress);
        dialogEmail = dialog.findViewById(R.id.updateDialogEmail);
        dialogPassword = dialog.findViewById(R.id.updateDialogPassword);
        dialogAddUserBtn = dialog.findViewById(R.id.updateDialogAddUserBtn);



        addUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Dialog dialog = new Dialog(AdminShowUsersRecyclerView.this);
//                dialog.setContentView(R.layout.add_user_dialog);
//                EditText dialogFirstname = dialog.findViewById(R.id.dialogFirstname);
//                EditText dialogLastname = dialog.findViewById(R.id.dialogLastname);
//                EditText dialogCity = dialog.findViewById(R.id.dialogCity);
//                EditText dialogAddress = dialog.findViewById(R.id.dialogAddress);
//                EditText dialogEmail = dialog.findViewById(R.id.dialogEmail);
//                EditText dialogPassword = dialog.findViewById(R.id.dialogPassword);
//                Button dialogAddUserBtn = dialog.findViewById(R.id.dialogAddUserBtn);
                dialog.show();

                dialogAddUserBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {



                        if (checkIfUserExists()){

                            Toast.makeText(AdminShowUsersRecyclerView.this, "User Already Exists !", Toast.LENGTH_SHORT).show();

                        }
                        else if (!validateEmail()){

                        Toast.makeText(AdminShowUsersRecyclerView.this, "Please enter a valid email ", Toast.LENGTH_SHORT).show();

                        }

                        else if (!dialogFirstname.getText().toString().isEmpty() && !dialogLastname.getText().toString().isEmpty() && !dialogCity.getText().toString().isEmpty() && !dialogAddress.getText().toString().isEmpty() && !dialogEmail.getText().toString().isEmpty() && !dialogPassword.getText().toString().isEmpty()) {

                            User user = new User(dialogFirstname.getText().toString(),dialogLastname.getText().toString(),dialogCity.getText().toString(),dialogAddress.getText().toString(),dialogEmail.getText().toString(),dialogPassword.getText().toString());
                            addUser(user);
                            userList = getAllUsers();
                            adapter.notifyItemInserted(userList.size() - 1); // last index

//                            dialog.dismiss();
                            Toast.makeText(AdminShowUsersRecyclerView.this, "User Added Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(AdminShowUsersRecyclerView.this, AdminShowUsersRecyclerView.class);
                            startActivity(intent);
//                            adminShowUsersRecyclerView.scrollToPosition(userList.size() - 1);

                        }

                        else{
                            Toast.makeText(AdminShowUsersRecyclerView.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                        }


                    }
                });

            }
        });


    }

    List<User> getAllUsers() {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        userList = myDataBase.userDao().getAllUsers();
        return userList;
    }


    private void addUser(User user) {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        myDataBase.userDao().insertUser(user);

    }
    private boolean checkIfUserExists() {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        userrList = myDataBase.userDao().getUserByEmail(dialogEmail.getText().toString());

        for (User user : userrList) {
            if (user.getEmail().equals(dialogEmail.getText().toString())) {
                return true;
            }

        }
        return false;
    }

    private boolean validateEmail() {

        if (Patterns.EMAIL_ADDRESS.matcher(dialogEmail.getText().toString()).matches()) {
            return true;
        }

        return false;

    }

}