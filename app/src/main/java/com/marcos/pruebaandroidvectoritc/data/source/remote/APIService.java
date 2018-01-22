package com.marcos.pruebaandroidvectoritc.data.source.remote;

import com.marcos.pruebaandroidvectoritc.data.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by markc on 22/01/2018.
 */

public interface APIService {

    @GET("users")
    Call<List<User>> getUsers();

    @GET("users/{username}")
    Call<User> getUser(@Path("username") String username);
}
