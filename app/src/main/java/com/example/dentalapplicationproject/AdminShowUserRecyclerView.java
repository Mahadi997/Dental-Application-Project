package com.example.dentalapplicationproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.dentalapplicationproject.DB.MyDataBase;
import com.example.dentalapplicationproject.DB.User;
import com.example.dentalapplicationproject.RecyclerViewAdapter.AdminShowUsersRecyclerViewAdapter;
import com.example.dentalapplicationproject.RecyclerViewAdapter.DoctorRecyclerViewAdapter;

import java.util.List;

public class AdminShowUserRecyclerView extends AppCompatActivity {

    private RecyclerView adminShowUsersRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_show_user_recycler_view);

        adminShowUsersRecyclerView = findViewById(R.id.adminShowUsersRecyclerView);
        adminShowUsersRecyclerView.setAdapter(new AdminShowUsersRecyclerViewAdapter(getAllUsers()));
        adminShowUsersRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));



    }

    private List<User> getAllUsers(){

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        return myDataBase.userDao().getAllUsers();


    }

}