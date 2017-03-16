package com.sarahehabm.orangerx.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Sarah E. Mostafa on 16-Mar-17.
 */
public class LocationList {
    @SerializedName("data")
    private ArrayList<Location> locationList;

    public LocationList() {
    }

    public LocationList(ArrayList<Location> locationList) {

        this.locationList = locationList;
    }

    public ArrayList<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(ArrayList<Location> locationList) {
        this.locationList = locationList;
    }
}
