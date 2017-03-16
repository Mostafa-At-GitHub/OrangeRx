package com.sarahehabm.orangerx.business;

import com.sarahehabm.orangerx.model.LocationList;

/**
 * Created by Sarah E. Mostafa on 16-Mar-17.
 */
public interface OnLocationsRetrievedListener {

    void onLocationListRetrievedSuccess(LocationList locationList);

    void onLocationListRetrievedFailure(String error);
}
