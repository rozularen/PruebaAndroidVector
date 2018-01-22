package com.marcos.pruebaandroidvectoritc.details;

import com.marcos.pruebaandroidvectoritc.data.User;

/**
 * Created by markc on 22/01/2018.
 */

public class DetailsContract {
    interface View {
        void setPresenter(Presenter presenter);

        void showUser(User user);

        void showLoadUserError();

        void setLoadingIndicator(boolean isLoading);
    }
    interface Presenter {
        void start();
        void onDestroy();
    }
}
