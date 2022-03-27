package com.example.dentalapplicationproject.DB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;




    @Entity()
    public class User {
        @PrimaryKey(autoGenerate = true)
        private int id;
        private String firstName;
        private String lastName;
        private String city;
        private String address;
        private String email;
        private String password;

        public User(String firstName, String lastName, String city, String address, String email, String password) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.city = city;
            this.address = address;
            this.email = email;
            this.password = password;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getCity() {
            return city;
        }

        public String getAddress() {
            return address;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }


        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }


