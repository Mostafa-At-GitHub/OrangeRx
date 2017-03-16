package com.sarahehabm.orangerx.business;

import com.sarahehabm.orangerx.model.User;
import com.sarahehabm.orangerx.model.UserList;

/**
 * Created by Sarah E. Mostafa on 12-Mar-17.
 */
public interface OnUserRetrievedListener {
    void onUserRetrievedSuccess(User user);

    void onUserRetrievedFailure(String error);

    void onUserListRetrievedSuccess(UserList userList);

    void onUserListRetrievedFailure(String error);
}
