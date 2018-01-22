package com.marcos.pruebaandroidvectoritc.data.source;

import com.marcos.pruebaandroidvectoritc.data.User;

import java.util.List;

/**
 * Created by markc on 22/01/2018.
 */

public interface UsersDataSource {
    void getUsers(LoadUsersCallback callback);

    void getUser(String username, LoadUserCallback callback);

    interface LoadUsersCallback {
        void onUsersLoaded(List<User> users);

        void onError();
    }

    interface LoadUserCallback {
        void onUserLoaded(User user);

        void onError();
    }
}
