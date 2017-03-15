package com.sarahehabm.orangerx.business;

import android.content.Context;

import com.sarahehabm.orangerx.model.User;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Sarah E. Mostafa on 12-Mar-17.
 */
public class MainBusiness {
    private Services services;

    public MainBusiness(Services services) {
        this.services = services;
    }

    public void getUser(Context context, final OnUserRetrievedListener userRetrievedListener) {
        services.getApi()
                .getUser()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        userRetrievedListener.onUserRetrievedFailure();
                    }

                    @Override
                    public void onNext(User user) {
                        userRetrievedListener.onUserRetrievedSuccess(user);
                    }
                });
    }
}
