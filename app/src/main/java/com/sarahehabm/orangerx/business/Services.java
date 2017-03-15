package com.sarahehabm.orangerx.business;


import com.sarahehabm.orangerx.model.User;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.GET;
import rx.Observable;

/**
 * Created by Sarah E. Mostafa on 15-Mar-17.
 */
public class Services {
    private static final String BASE_URL = "http://demo1043736.mockable.io";
    private Apis apis;

    public Services() {
        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Accept", "application/json");
            }
        };

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setRequestInterceptor(requestInterceptor)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        apis = restAdapter.create(Apis.class);
    }

    public Apis getApi() {
        return apis;
    }

    public interface Apis {
        @GET("/getUser")
        Observable<User> getUser();
    }
}
