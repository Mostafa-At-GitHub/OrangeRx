package com.sarahehabm.orangerx.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.sarahehabm.orangerx.R;
import com.sarahehabm.orangerx.business.MainBusiness;
import com.sarahehabm.orangerx.business.OnLocationsRetrievedListener;
import com.sarahehabm.orangerx.business.OnUserRetrievedListener;
import com.sarahehabm.orangerx.business.Services;
import com.sarahehabm.orangerx.model.LocationList;
import com.sarahehabm.orangerx.model.User;
import com.sarahehabm.orangerx.model.UserList;


public class MainActivity extends AppCompatActivity implements OnUserRetrievedListener, OnLocationsRetrievedListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    private MainBusiness mainBusiness;

    private TextView textViewUserId, textViewUserName, textViewUserJob;
    private RecyclerView recyclerViewUsers, recyclerViewLocations;
    private ProgressBar progressBarUser, progressBarUsers, progressBarLocations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();

        mainBusiness = new MainBusiness(new Services());

        progressBarUser.setVisibility(View.VISIBLE);
        mainBusiness.getUser(this);

        progressBarUsers.setVisibility(View.VISIBLE);
        mainBusiness.getUserList(this);

        progressBarLocations.setVisibility(View.VISIBLE);
        mainBusiness.getLocationList(this);
    }

    private void initializeViews() {
        textViewUserId = (TextView) findViewById(R.id.textView_userId);
        textViewUserName = (TextView) findViewById(R.id.textView_userName);
        textViewUserJob = (TextView) findViewById(R.id.textView_userJob);
        recyclerViewUsers = (RecyclerView) findViewById(R.id.recyclerView_users);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewUsers.setLayoutManager(linearLayoutManager);
        recyclerViewLocations = (RecyclerView) findViewById(R.id.recyclerView_locations);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewLocations.setLayoutManager(linearLayoutManager);

        progressBarUser = (ProgressBar) findViewById(R.id.progressBar);
        progressBarUsers = (ProgressBar) findViewById(R.id.progressBar_users);
        progressBarLocations = (ProgressBar) findViewById(R.id.progressBar_locations);
    }

    @Override
    public void onUserRetrievedSuccess(User user) {
        Log.e(TAG, "userRetrievedSuccess; username= " + user.getName());

        progressBarUser.setVisibility(View.GONE);

        textViewUserId.setText(String.valueOf(user.getId()));
        textViewUserName.setText(user.getName());
        textViewUserJob.setText(user.getJob_title());
    }

    @Override
    public void onUserRetrievedFailure(String error) {
        Log.e(TAG, "userRetrievedFailure");

        progressBarUser.setVisibility(View.GONE);
        Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUserListRetrievedSuccess(UserList userList) {
        Log.e(TAG, "userListRetrievedSuccess");

        progressBarUsers.setVisibility(View.GONE);

        UserListAdapter userListAdapter = new UserListAdapter(this, userList.getUserList());
        recyclerViewUsers.setAdapter(userListAdapter);
    }

    @Override
    public void onUserListRetrievedFailure(String error) {
        Log.e(TAG, "userListRetrievedFailure");

        progressBarUsers.setVisibility(View.GONE);
        Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLocationListRetrievedSuccess(LocationList locationList) {
        Log.e(TAG, "locationListRetrievedSuccess");

        progressBarLocations.setVisibility(View.GONE);

        LocationListAdapter locationListAdapter = new LocationListAdapter(this, locationList.getLocationList());
        recyclerViewLocations.setAdapter(locationListAdapter);
    }

    @Override
    public void onLocationListRetrievedFailure(String error) {
        Log.e(TAG, "locationListRetrievedFailure");

        progressBarLocations.setVisibility(View.GONE);
        Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
    }
}
