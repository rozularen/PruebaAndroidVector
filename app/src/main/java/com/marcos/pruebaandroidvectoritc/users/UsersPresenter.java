package com.marcos.pruebaandroidvectoritc.users;

import com.marcos.pruebaandroidvectoritc.data.User;
import com.marcos.pruebaandroidvectoritc.data.source.UsersDataSource;
import com.marcos.pruebaandroidvectoritc.data.source.UsersRepository;

import java.util.List;

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


    @Override
    public void start() {
        loadUsers();
    }

    private void loadUsers() {
        view.setLoadingIndicator(true);

        usersRepository.getUsers(new UsersDataSource.LoadUsersCallback() {
            @Override
            public void onUsersLoaded(List<User> users) {
                view.setLoadingIndicator(false);
                view.showUsers(users);
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public void onDestroy() {
        view = null;
    }
}
