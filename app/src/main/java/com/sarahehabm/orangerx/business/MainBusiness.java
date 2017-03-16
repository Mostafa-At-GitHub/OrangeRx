package com.sarahehabm.orangerx.business;

import com.sarahehabm.orangerx.model.LocationList;
import com.sarahehabm.orangerx.model.User;
import com.sarahehabm.orangerx.model.UserList;

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

    public void getUser(final OnUserRetrievedListener userRetrievedListener) {
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
                        String errorMessage = e == null ? null : e.getLocalizedMessage();
                        userRetrievedListener.onUserRetrievedFailure(errorMessage);
                    }

                    @Override
                    public void onNext(User user) {
                        userRetrievedListener.onUserRetrievedSuccess(user);
                    }
                });
    }

    public void getUserList(final OnUserRetrievedListener userRetrievedListener) {
        services.getApi()
                .getUserList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserList>(){

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        String errorMessage = e == null ? null : e.getLocalizedMessage();
                        userRetrievedListener.onUserListRetrievedFailure(errorMessage);
                    }

                    @Override
                    public void onNext(UserList userList) {
                        userRetrievedListener.onUserListRetrievedSuccess(userList);
                    }
                });
    }

    public void getLocationList(final OnLocationsRetrievedListener locationsRetrievedListener) {
        services.getApi()
                .getLocationList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LocationList>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        String errorMessage = e == null ? null : e.getLocalizedMessage();
                        locationsRetrievedListener.onLocationListRetrievedFailure(errorMessage);
                    }

                    @Override
                    public void onNext(LocationList locationList) {
                        locationsRetrievedListener.onLocationListRetrievedSuccess(locationList);
                    }
                });
    }
}
