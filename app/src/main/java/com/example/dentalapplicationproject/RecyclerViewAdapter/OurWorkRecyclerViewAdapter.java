package com.example.dentalapplicationproject.RecyclerViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dentalapplicationproject.DB.DataConvertor;
import com.example.dentalapplicationproject.DB.Doctor;
import com.example.dentalapplicationproject.DB.DoctorImages;
import com.example.dentalapplicationproject.R;
import com.example.dentalapplicationproject.ViewHolders.DoctorViewHolder;
import com.example.dentalapplicationproject.ViewHolders.OurWorkViewHolder;

import java.util.List;

public class OurWorkRecyclerViewAdapter  extends RecyclerView.Adapter<OurWorkViewHolder>{

private List<DoctorImages> doctorImagesList;
    private List<Doctor> doctorList;

    public OurWorkRecyclerViewAdapter(List<DoctorImages> doctorImagesList, List<Doctor> doctorList) {
        this.doctorImagesList = doctorImagesList;
        this.doctorList = doctorList;
    }

    @NonNull
    @Override
    public OurWorkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.our_work_row, parent, false);
        OurWorkViewHolder ourWorkViewHolder = new OurWorkViewHolder(view);
        return ourWorkViewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull OurWorkViewHolder holder, int position) {

        holder.getOurWorkImage().setImageBitmap(DataConvertor.convertByteArray2Image(doctorImagesList.get(position).getImage()));
        holder.getWorkDoctorNameAndSurname().setText(getDoctorNameById(doctorImagesList.get(position).getDoctorId()));



    }

    @Override
    public int getItemCount() {
        return doctorImagesList.size();
    }

    private String getDoctorNameById(int doctorId){

        for (Doctor doctor: doctorList){

            if (doctor.getId() == doctorId){

                return "Doctor: " + doctor.getName() + " " + doctor.getSurname();
            }

        }

        return null;

    }

}
