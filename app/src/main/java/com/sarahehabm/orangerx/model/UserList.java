package com.sarahehabm.orangerx.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Sarah E. Mostafa on 16-Mar-17.
 */
public class UserList {
    @SerializedName("data")
    private ArrayList<User> userList;

    public UserList() {

    }

    public UserList(ArrayList<User> userList) {

        this.userList = userList;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }
}
