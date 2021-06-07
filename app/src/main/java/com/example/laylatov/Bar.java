package com.example.laylatov;

public class Bar {
    private final String name;
    private double lat;
    private double lng;


    public Bar(String name, double lat, double lng){
        this.name = name;
        this.lat = lat;
        this.lng = lng;
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
}
