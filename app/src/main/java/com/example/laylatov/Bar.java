package com.example.laylatov;

public class Bar {
    private final String name;
    private float lat;
    private float lng;


    public Bar(String name, float lat, float lng){
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

    public float getLat() {
        return lat;
    }

    public float getLng() {
        return lng;
    }

    public String getName() {
        return name;
    }
}
