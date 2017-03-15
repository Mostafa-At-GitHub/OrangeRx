package com.sarahehabm.orangerx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sarahehabm.orangerx.business.MainBusiness;
import com.sarahehabm.orangerx.business.OnUserRetrievedListener;
import com.sarahehabm.orangerx.business.Services;
import com.sarahehabm.orangerx.model.User;


public class MainActivity extends AppCompatActivity implements OnUserRetrievedListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    private Services services;
    private MainBusiness mainBusiness;

    private TextView textViewUserId, textViewUserName, textViewUserJob;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();

        services = new Services();
        mainBusiness = new MainBusiness(services);

        progressBar.setVisibility(View.VISIBLE);
        mainBusiness.getUser(this, this);
    }

    private void initializeViews() {
        textViewUserId = (TextView) findViewById(R.id.textView_userId);
        textViewUserName = (TextView) findViewById(R.id.textView_userName);
        textViewUserJob = (TextView) findViewById(R.id.textView_userJob);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    public void onUserRetrievedSuccess(User user) {
        Log.e(TAG, "userRetrievedSuccess; username= " + user.getName());

        progressBar.setVisibility(View.GONE);

        textViewUserId.setText(String.valueOf(user.getId()));
        textViewUserName.setText(user.getName());
        textViewUserJob.setText(user.getJob_title());
    }

    @Override
    public void onUserRetrievedFailure() {
        Log.e(TAG, "userRetrievedFailure");

        progressBar.setVisibility(View.GONE);
    }
}
