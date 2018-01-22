package com.marcos.pruebaandroidvectoritc.users;

import com.marcos.pruebaandroidvectoritc.data.source.UsersRepository;

/**
 * Created by markc on 22/01/2018.
 */

public class UsersPresenter implements UsersContract.Presenter {

    private UsersContract.View view;
    private final UsersRepository usersRepository;

    public UsersPresenter(UsersRepository usersRepository, UsersContract.View view) {
        this.usersRepository = usersRepository;
        this.view = view;
        view.setPresenter(this);
    }

    public void onDestroy() {
        view = null;
    }
}
