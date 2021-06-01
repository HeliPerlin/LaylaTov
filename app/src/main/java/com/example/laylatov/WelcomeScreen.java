package com.example.laylatov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        Button findBarsBtn = (Button) findViewById(R.id.findBars);

        Button goToInfoBtn = (Button) findViewById(R.id.goToInfo);

        findBarsBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                moveToFindBarsScreen();
            }
        });

        goToInfoBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) { moveToInfoScreen(); }
        });
    }

    public void moveToInfoScreen(){
        Intent intent = new Intent(this, chooseInfoType.class);
        startActivity(intent);
    }

    public void moveToFindBarsScreen(){
        Intent intent = new Intent(this, UsefulInfoClient.class); // TODO: ADD SCREEN
        startActivity(intent);
    }

}