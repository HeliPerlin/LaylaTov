package com.example.laylatov;

import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class findPlaces extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_places);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ArrayList<Bar> allBars = new ArrayList<>();
        // iterate over the data in the database, for each row create a bar instance with name, lat, lng


        Button button_location;
        TextView textView_location;
        LocationManager locationManager;



        //findAllBars(0, 0, allBars, 0);
        // TODO: Call finding all bars function
        // TODO: 1. retrieve self location 2. create a allBars array
        // TODO: 3. create the button that receives a distance and calls the findAllBars function

    }
    ArrayList<Bar> findAllBars(float latA, float lngA, ArrayList<Bar> allBars, int range){
        ArrayList<Bar> barsInRange = new ArrayList<>();
        Location selfLocation = new Location("selfLocation");
        selfLocation.setLatitude(latA);
        selfLocation.setLongitude(lngA);
        for(Bar bar: allBars){
            Location otherLocation = new Location(bar.getName());
            selfLocation.setLatitude(bar.getLat());
            selfLocation.setLongitude(lngA);
            float distance = findDistance(selfLocation, otherLocation);
            if(distance <= range){
                barsInRange.add(bar);
            }
        }
        return barsInRange;
    }

    float findDistance(Location selfLocation, Location otherLocation) {

        return selfLocation.distanceTo(otherLocation);
    }
}