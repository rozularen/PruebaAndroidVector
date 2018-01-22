package com.marcos.pruebaandroidvectoritc.data.source;

import com.marcos.pruebaandroidvectoritc.data.User;

import java.util.List;

/**
 * Created by markc on 22/01/2018.
 */

public interface UsersDataSource {
    void getUsers(LoadUsersCallback callback);

    void getUser(int id);

    interface LoadUsersCallback {
        void onUsersLoaded(List<User> users);

        void onError();
    }
}
