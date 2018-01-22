package com.marcos.pruebaandroidvectoritc.data.source.remote;

import android.util.Log;

import com.marcos.pruebaandroidvectoritc.data.User;
import com.marcos.pruebaandroidvectoritc.data.source.UsersDataSource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by markc on 22/01/2018.
 */

public class UsersRemoteDataSource implements UsersDataSource {

    private static final String TAG = "UsersRemoteDS";
    private static UsersRemoteDataSource INSTANCE;
    private final APIService apiService;

    private UsersRemoteDataSource() {
        Retrofit client = APIClient.getClient();

        this.apiService = client.create(APIService.class);
    }

    public static UsersRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UsersRemoteDataSource();
        }
        return INSTANCE;
    }

    @Override
    public void getUsers(final LoadUsersCallback callback) {
        Call<List<User>> call = apiService.getUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.code() == 200) {
                    List<User> users = response.body();

                    callback.onUsersLoaded(users);
                } else {
                    Log.e(TAG, "onResponse: Request returned code " + response.code());
                    callback.onError();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                callback.onError();
            }
        });
    }

    @Override
    public void getUser(String username, final LoadUserCallback callback) {
        Call<User> call = apiService.getUser(username);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.code() == 200) {
                    User user = response.body();

                    callback.onUserLoaded(user);
                } else {
                    Log.e(TAG, "onResponse: Request returned code " + response.code());
                    callback.onError();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                callback.onError();
            }
        });
    }


}
