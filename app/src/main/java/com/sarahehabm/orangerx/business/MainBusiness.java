package com.sarahehabm.orangerx.business;

import android.content.Context;

/**
 * Created by Sarah E. Mostafa on 12-Mar-17.
 */
public class MainBusiness {
    private static final String BASE_URL = "http://demo1043736.mockable.io";

    public static void getUser(Context context, final OnUserRetrievedListener userRetrievedListener) {
        String url = BASE_URL + "/getUser";

        //Execute method
    }
}
