package com.marcos.pruebaandroidvectoritc.details;

import com.marcos.pruebaandroidvectoritc.data.User;
import com.marcos.pruebaandroidvectoritc.data.source.UsersDataSource;
import com.marcos.pruebaandroidvectoritc.data.source.UsersRepository;

/**
 * Created by markc on 22/01/2018.
 */

public class DetailsPresenter implements DetailsContract.Presenter {

    private final String username;
    private DetailsContract.View view;
    private UsersRepository usersRepository;

    public DetailsPresenter(String username, DetailsContract.View view, UsersRepository usersRepository) {
        this.username = username;
        this.usersRepository = usersRepository;
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        loadUser(username);
    }

    private void loadUser(String username) {
        usersRepository.getUser(username, new UsersDataSource.LoadUserCallback() {
            @Override
            public void onUserLoaded(User user) {
                view.showUser(user);
            }

            @Override
            public void onError() {
                view.showLoadUserError();
            }
        });
    }

    @Override
    public void onStop() {
        view = null;
    }
}
