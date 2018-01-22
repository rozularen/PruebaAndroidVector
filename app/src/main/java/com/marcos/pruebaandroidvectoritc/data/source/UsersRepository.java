package com.marcos.pruebaandroidvectoritc.data.source;

import com.marcos.pruebaandroidvectoritc.data.User;

import java.util.List;

/**
 * Created by markc on 22/01/2018.
 */

public class UsersRepository implements UsersDataSource {

    private static final String TAG = "UsersRepository";
    private static UsersRepository INSTANCE = null;
    private UsersDataSource remoteDataSource;

    private UsersRepository(UsersDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public static UsersRepository getInstance(UsersDataSource remoteDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new UsersRepository(remoteDataSource);
        }

        return INSTANCE;
    }

    @Override
    public void getUsers(final LoadUsersCallback callback) {
        remoteDataSource.getUsers(new LoadUsersCallback() {
            @Override
            public void onUsersLoaded(List<User> users) {
                callback.onUsersLoaded(users);
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });
    }

    @Override
    public void getUser(String username, final LoadUserCallback callback) {
        remoteDataSource.getUser(username, new LoadUserCallback() {
            @Override
            public void onUserLoaded(User user) {
                callback.onUserLoaded(user);
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });
    }
}
