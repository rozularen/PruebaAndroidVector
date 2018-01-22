package com.marcos.pruebaandroidvectoritc.data.source;

import com.marcos.pruebaandroidvectoritc.data.User;

import java.util.List;

/**
 * Created by markc on 22/01/2018.
 */

public interface UsersDataSource {
    List<User> getUsers();

    User getUser(int id);
}
