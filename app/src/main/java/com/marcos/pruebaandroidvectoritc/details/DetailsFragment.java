package com.marcos.pruebaandroidvectoritc.details;


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
public class DetailsFragment extends Fragment implements DetailsContract.View {

    private DetailsContract.Presenter presenter;

    public DetailsFragment() {
        // Required empty public constructor
    }

    public static DetailsFragment newInstance(String username) {
        Bundle args = new Bundle();
        args.putString("username", username);
        DetailsFragment detailsFragment = new DetailsFragment();
        detailsFragment.setArguments(args);
        return detailsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void setPresenter(DetailsContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
