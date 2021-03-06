package com.example.dentalapplicationproject.DB;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.room.TypeConverter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class DataConvertor {

    @TypeConverter
public static byte[] convertImage2ByteArray(Bitmap bitmap){

    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    bitmap.compress(Bitmap.CompressFormat.JPEG,0,stream);
    return stream.toByteArray();

}


@TypeConverter
public static Bitmap convertByteArray2Image(byte[] array){

        return BitmapFactory.decodeByteArray(array,0,array.length);

}


}
