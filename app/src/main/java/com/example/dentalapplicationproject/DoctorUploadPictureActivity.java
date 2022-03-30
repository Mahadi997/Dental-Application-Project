package com.example.dentalapplicationproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dentalapplicationproject.DB.DataConvertor;
import com.example.dentalapplicationproject.DB.DoctorImages;
import com.example.dentalapplicationproject.DB.MyDataBase;

public class DoctorUploadPictureActivity extends AppCompatActivity {

    private int doctorId;
    private final int CAMERA_REQUEST_CODE = 100;
    ImageView imgCamera;
    Button btnCamera;
    Button btnCameraUpload;
   private Bitmap img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_upload_picture);
        doctorId = getIntent().getIntExtra("id", 0);
        imgCamera = findViewById(R.id.imgCamera);
        btnCamera = findViewById(R.id.btnCamera);
        btnCameraUpload = findViewById(R.id.btnCameraUpload);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent iCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(iCamera, CAMERA_REQUEST_CODE);


            }
        });

        btnCameraUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (imgCamera.getDrawable() == null){

                    Toast.makeText(DoctorUploadPictureActivity.this, "Please select your picture", Toast.LENGTH_SHORT).show();

                }
                else{

                    DoctorImages image = new DoctorImages(doctorId, DataConvertor.convertImage2ByteArray(img));
                    insertImage(image);
                    Toast.makeText(DoctorUploadPictureActivity.this, "Image Inserted Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DoctorUploadPictureActivity.this, DoctorActivity.class);
                    intent.putExtra("id",doctorId);
                    startActivity(intent);

                }







            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            if (requestCode == CAMERA_REQUEST_CODE) {

                //for camera
                 img = (Bitmap) data.getExtras().get("data");
                imgCamera.setImageBitmap(img);


            }

        }


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), DoctorActivity.class);
        myIntent.putExtra("id", doctorId);
        startActivityForResult(myIntent, 0);
        return true;
    }

    private void insertImage(DoctorImages image){

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        myDataBase.doctorImagesDao().insertImage(image);

    }


}