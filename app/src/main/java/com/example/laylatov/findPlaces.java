package com.example.laylatov;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class findPlaces extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Spinner range_spinner;
    private static final int REQUEST_LOCATION = 1;

    LocationManager locationManager;
    double latitude,longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_places);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // iterate over the data in the database, for each row create a bar instance with name, lat, lng

//        add permissions
        ActivityCompat.requestPermissions(this, new String[]
                {Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION);


        range_spinner = (Spinner) findViewById(R.id.range_spinner);
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this,R.array.distances, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        range_spinner.setAdapter(adapter);
        range_spinner.setOnItemSelectedListener(this);


        Button search_button = (Button) findViewById(R.id.search_btn);
        ArrayList<Bar> allBars = new ArrayList<>();

        Bar newBar1 = new Bar("Monaco", 31.7534989,35.3061771);
        Bar newBar2 = new Bar("Toy", 31.7534989,35.3061771);
        Bar newBar3 = new Bar("Lago", 31.7534989,35.3061771);

        allBars.add(newBar1);
        allBars.add(newBar2);
        allBars.add(newBar3);


        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

//                Check weather GPS is enabled or not

                if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
                {
//                    function to enable GPS
                    OnGPS();
                }
                else
                {
//                    GPS is already on
                    getLocation();
                }

                ArrayList<Bar> newArr = findAllBars(latitude,longitude, allBars,
                        Integer.parseInt(range_spinner.getSelectedItem().toString()));

                System.out.println(Integer.parseInt(range_spinner.getSelectedItem().toString()));

                if (newArr.isEmpty())
                {
                    System.out.println("array empty - no bars nearby");
                }
                else
                {
                    for (Bar bar : newArr){
                        System.out.println(bar.getName());
                    }
                }

            }



        });
    }
    private void OnGPS() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Please Enable GPS").setCancelable(false).
                setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void getLocation() {
//        Check Permissions Again
        if (ActivityCompat.checkSelfPermission
                (findPlaces.this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(findPlaces.this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION);

        }
        else {
            Location locationGPS = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            Location locationNetwork = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            Location locationPassive = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);

            if (locationGPS != null)
            {
                latitude = locationGPS.getLatitude();
                longitude = locationGPS.getLongitude();

                System.out.println("GPS:\n lat = "+latitude + "\nlng = "+longitude);
            }
            else if (locationNetwork != null)
            {
                latitude = locationNetwork.getLatitude();
                longitude = locationNetwork.getLongitude();
                System.out.println("Network:\n lat = "+latitude + "\nlng = "+longitude);

            }
            else if (locationPassive != null)
            {
                latitude = locationPassive.getLatitude();
                longitude = locationPassive.getLongitude();

                System.out.println("Passive:\n lat = "+latitude + "\nlng = "+longitude);

            }
            else
            {
                Toast.makeText(this,"Can't get your Location",Toast.LENGTH_SHORT).show();
            }

        }
        }


        // TODO: Call finding all bars function
        // TODO: 1. retrieve self location 2. create a allBars array
        // TODO: 3. create the button that receives a distance and calls the findAllBars function

    ArrayList<Bar> findAllBars(double latA, double lngA, ArrayList<Bar> allBars, int range){
        ArrayList<Bar> barsInRange = new ArrayList<>();
        Location selfLocation = new Location("selfLocation");
        selfLocation.setLatitude(latA);
        selfLocation.setLongitude(lngA);
        for(Bar bar: allBars){
            Location otherLocation = new Location(bar.getName());
            otherLocation.setLatitude(bar.getLat());
            otherLocation.setLongitude(bar.getLng());
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
//        String text = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}