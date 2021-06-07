package com.example.laylatov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

//
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("HaTaklit");
        myRef.setValue("307.2222, 201.4444");
        DatabaseReference myRef1 = database.getReference("ShoshanaBar");
        myRef1.setValue("569.2222, 201231.4444");
        DatabaseReference myRef2 = database.getReference("HaMalben");
        myRef2.setValue("12317.2223422, 201.4444");


//        String strKey = myRef.getKey();
//        System.out.println("Key is " + strKey);


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
        Intent intent = new Intent(this, findPlaces.class); // TODO: ADD SCREEN
        startActivity(intent);
    }

}