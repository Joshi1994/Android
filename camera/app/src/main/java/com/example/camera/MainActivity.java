package com.example.camera;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ImageView pictureImageView;
    Button cameraButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pictureImageView = findViewById(R.id.imageViewPicture);
        cameraButton = findViewById(R.id.buttonCamera);
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
                    takePicture();
                }else{
                    sendCameraIntent();
                }

            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    void takePicture(){
        if(getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            if(checkSelfPermission(Manifest.permission.CAMERA) !=
            PackageManager.PERMISSION_GRANTED){
                requestPermissions(new String[]{Manifest.permission.CAMERA},100);
            }else{
                    sendCameraIntent();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 100){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                sendCameraIntent();
            }else{
                Toast.makeText(this,"Camera permission denied",Toast.LENGTH_LONG)
                        .show();
            }
        }
    }
    String picturePath;
    void sendCameraIntent(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_FINISH_ON_COMPLETION,true);
        if(intent.resolveActivity(getPackageManager()) !=null){
            File pictureFile = null;
            try{
                String timeStamp = new SimpleDateFormat("yyyyMMMMddHHmmss")
                        .format(new Date());
                String picName = "pic_"+ timeStamp;
                File dir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                pictureFile = File.createTempFile(picName,".jpg",dir);
                picturePath = pictureFile.getAbsolutePath();
            }catch(Exception e){
                e.printStackTrace();
                Toast.makeText(this,"Photo file could not be created",Toast.LENGTH_LONG)
                        .show();
            }
            if(pictureFile != null){
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.camera.fileprovider",
                        pictureFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT,photoURI);
                startActivityForResult(intent,101);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101 && resultCode == RESULT_OK){
            File file = new File(picturePath);
            if(file.exists()){
                pictureImageView.setImageURI(Uri.fromFile(file));
            }else{
                Log.d("FILE_PROBLEM", picturePath);
            }
        }
    }

}
