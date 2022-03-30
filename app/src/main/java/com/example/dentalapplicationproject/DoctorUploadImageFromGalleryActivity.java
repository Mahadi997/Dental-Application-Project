package com.example.dentalapplicationproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class DoctorUploadImageFromGalleryActivity extends AppCompatActivity {

    private int doctorId;
    ImageView imgGallery;
    Button btnGallery;
    Button btnGalleryUpload;
    private final int GALLERY_REQUEST_CODE = 1000;
    private Bitmap img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_upload_image_from_gallery);
        doctorId = getIntent().getIntExtra("id", 0);
        imgGallery = findViewById(R.id.imgGallery);
        btnGallery = findViewById(R.id.btnGallery);
        btnGalleryUpload = findViewById(R.id.btnGalleryUpload);


        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent iGallery = new Intent(Intent.ACTION_PICK);
//                iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(iGallery, GALLERY_REQUEST_CODE);
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), GALLERY_REQUEST_CODE);


            }
        });

        btnGalleryUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (imgGallery.getDrawable() == null) {

                    Toast.makeText(DoctorUploadImageFromGalleryActivity.this, "Please select your picture", Toast.LENGTH_SHORT).show();

                } else {

                    img = ((BitmapDrawable) imgGallery.getDrawable()).getBitmap();
                    DoctorImages image = new DoctorImages(doctorId, DataConvertor.convertImage2ByteArray(img));
                    insertImage(image);
                    Toast.makeText(DoctorUploadImageFromGalleryActivity.this, "Image Inserted Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DoctorUploadImageFromGalleryActivity.this, DoctorActivity.class);
                    intent.putExtra("id", doctorId);
                    startActivity(intent);

                }

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK) {

            //for gallery

            try {
                Uri selectedImage = data.getData();
                InputStream imageStream = getContentResolver().openInputStream(selectedImage);
                imgGallery.setImageBitmap(BitmapFactory.decodeStream(imageStream));

            } catch (IOException exception) {
                exception.printStackTrace();
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

    private void insertImage(DoctorImages image) {

        MyDataBase myDataBase = MyDataBase.getInstance(getApplicationContext());
        myDataBase.doctorImagesDao().insertImage(image);

    }

}