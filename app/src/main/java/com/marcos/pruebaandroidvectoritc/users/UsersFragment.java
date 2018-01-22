package com.marcos.pruebaandroidvectoritc.users;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marcos.pruebaandroidvectoritc.R;

import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class UsersFragment extends Fragment implements UsersContract.View {


    private UsersContract.Presenter presenter;

    public UsersFragment() {
        // Required empty public constructor
    }

    public static UsersFragment newInstance() {
        return new UsersFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void setPresenter(UsersContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
