package com.sarahehabm.orangerx.business;

import com.sarahehabm.orangerx.model.User;

/**
 * Created by Sarah E. Mostafa on 12-Mar-17.
 */
public interface OnUserRetrievedListener {
    void onUserRetrievedSuccess(User user);

    void onUserRetrievedFailure();
}
