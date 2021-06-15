package com.example.laylatov;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bar);


        Button googleMapsBtn = (Button) findViewById(R.id.google_maps_site_Btn);

        googleMapsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { goToGoogleMaps();}

            private void goToGoogleMaps() {
                Uri uri = Uri.parse("https://www.google.com/maps");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);

            }
        });
    }

}

