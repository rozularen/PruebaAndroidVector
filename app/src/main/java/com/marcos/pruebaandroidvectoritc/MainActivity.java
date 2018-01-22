package com.marcos.pruebaandroidvectoritc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.marcos.pruebaandroidvectoritc.users.UsersFragment;
import com.marcos.pruebaandroidvectoritc.users.UsersPresenter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigateToMain();
    }

    private void navigateToMain() {
        UsersFragment usersFragment = UsersFragment.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, usersFragment)
                .commit();

        UsersPresenter mainPresenter = new UsersPresenter(usersFragment);
    }
}
