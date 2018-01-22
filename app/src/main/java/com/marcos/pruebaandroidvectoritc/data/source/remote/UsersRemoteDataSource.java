package com.marcos.pruebaandroidvectoritc.data.source.remote;

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
                List<User> users = response.body();

                callback.onUsersLoaded(users);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                callback.onError();
            }
        });
    }

    @Override
    public void getUser(int id) {

    }
}
