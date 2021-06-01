package com.example.laylatov;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class chooseInfoType extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_info_type);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button pdfBtn = findViewById(R.id.pdfBtn);
        pdfBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToPdf();
            }
        });


        Button videoBtn = findViewById(R.id.videoBtn);
        videoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToVideo();
            }
        });


    }

    public void goToPdf(){
        Intent intent = new Intent(this, UsefulInfoClient.class);
        startActivity(intent);
    }

    public void goToVideo(){
        Intent intent = new Intent(this, VideoScreen.class); // TODO: ADD SCREEN
        startActivity(intent);
    }
}