package com.marcos.pruebaandroidvectoritc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.marcos.pruebaandroidvectoritc.data.source.UsersDataSource;
import com.marcos.pruebaandroidvectoritc.data.source.UsersRepository;
import com.marcos.pruebaandroidvectoritc.data.source.remote.UsersRemoteDataSource;
import com.marcos.pruebaandroidvectoritc.details.DetailsFragment;
import com.marcos.pruebaandroidvectoritc.details.DetailsPresenter;
import com.marcos.pruebaandroidvectoritc.users.UsersFragment;
import com.marcos.pruebaandroidvectoritc.users.UsersPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        navigateToMain();
    }

    public void navigateToMain() {
        UsersFragment usersFragment = UsersFragment.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, usersFragment)
                .commit();

        UsersRemoteDataSource remoteDataSource = UsersRemoteDataSource.getInstance();

        UsersRepository usersRepository = UsersRepository.getInstance(remoteDataSource);

        UsersPresenter mainPresenter = new UsersPresenter(usersRepository, usersFragment);
    }

    public void navigateToDetails(String username) {
        DetailsFragment detailsFragment = DetailsFragment.newInstance(username);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, detailsFragment)
                .addToBackStack(DetailsFragment.TAG)
                .commit();

        UsersRemoteDataSource remoteDataSource = UsersRemoteDataSource.getInstance();

        UsersRepository usersRepository = UsersRepository.getInstance(remoteDataSource);

        DetailsPresenter detailsPresenter = new DetailsPresenter(username, usersRepository, detailsFragment);
    }
}
