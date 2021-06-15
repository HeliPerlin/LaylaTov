package com.example.laylatov;

import android.widget.TextView;

public class Bar {
    private final String name;
    private final double lat;
    private final double lng;
    private String siteURL;



    public Bar(String name, double lat, double lng, String siteURL){
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.siteURL = siteURL;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public String getName() {
        return name;
    }

    public String getSiteURL() { return siteURL; }
}
