package com.marcos.pruebaandroidvectoritc.users;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.marcos.pruebaandroidvectoritc.MainActivity;
import com.marcos.pruebaandroidvectoritc.R;
import com.marcos.pruebaandroidvectoritc.data.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class UsersFragment extends Fragment implements UsersContract.View {


    @BindView(R.id.pb_users_loading_indicator)
    ProgressBar pbUsersLoadingIndicator;
    @BindView(R.id.rv_users)
    RecyclerView rvUsers;
    private MainActivity mainActivity;
    private UsersAdapter usersAdapter;
    private UsersContract.Presenter presenter;
    private UsersAdapter.ItemClickListener itemClickListener = new UsersAdapter.ItemClickListener() {
        @Override
        public void onClick(View view, String username) {
            mainActivity.navigateToDetails(username);
        }
    };

    public UsersFragment() {
        // Required empty public constructor
    }

    public static UsersFragment newInstance() {
        return new UsersFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usersAdapter = new UsersAdapter(getContext(), itemClickListener, new ArrayList<User>(0));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.bind(this, view);

        mainActivity = (MainActivity) getActivity();

        ActionBar supportActionBar = mainActivity.getSupportActionBar();
        supportActionBar.setTitle("Directory");

        rvUsers.setAdapter(usersAdapter);

        rvUsers.setHasFixedSize(true);
        rvUsers.setItemAnimator(new DefaultItemAnimator());
        rvUsers.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void setPresenter(UsersContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setLoadingIndicator(boolean isLoading) {
        if (isLoading) {
            pbUsersLoadingIndicator.setVisibility(View.VISIBLE);
        } else {
            pbUsersLoadingIndicator.setVisibility(View.GONE);
        }
    }

    @Override
    public void showUsers(List<User> users) {
        usersAdapter.setUsers(users);
        usersAdapter.notifyDataSetChanged();
    }
}
