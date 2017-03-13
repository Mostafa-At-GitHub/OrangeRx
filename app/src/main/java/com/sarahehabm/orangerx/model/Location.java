package com.sarahehabm.orangerx.model;

/**
 * Created by Sarah E. Mostafa on 12-Mar-17.
 */
public class Location {
    private double longitude, latitude;

    public Location() {
    }

    public Location(double longitude, double latitude) {

        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
