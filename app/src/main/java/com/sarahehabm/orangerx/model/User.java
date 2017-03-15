package com.sarahehabm.orangerx.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sarah E. Mostafa on 12-Mar-17.
 */
public class User {
    @SerializedName("3id")
    private int id;
    private String name;
    private String job_title;

    public User() {

    }

    public User(int id, String name, String job_title) {

        this.id = id;
        this.name = name;
        this.job_title = job_title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public static User fromJson(String json) {
        return new Gson().fromJson(json, User.class);
    }
}
