package com.marcos.pruebaandroidvectoritc.users;

import com.marcos.pruebaandroidvectoritc.data.User;

import java.util.List;

/**
 * Created by markc on 22/01/2018.
 */

public interface UsersContract {
    interface View {
        void setPresenter(Presenter presenter);

        void setLoadingIndicator(boolean isLoading);

        void showUsers(List<User> users);

    }

    interface Presenter {

        void start();

        void onDestroy();
    }
}
