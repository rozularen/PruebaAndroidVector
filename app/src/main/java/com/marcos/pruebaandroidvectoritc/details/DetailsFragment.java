package com.marcos.pruebaandroidvectoritc.details;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.marcos.pruebaandroidvectoritc.MainActivity;
import com.marcos.pruebaandroidvectoritc.R;
import com.marcos.pruebaandroidvectoritc.data.User;
import com.marcos.pruebaandroidvectoritc.util.DateUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment implements DetailsContract.View {

    public static final String TAG = "DetailsFragment";
    @BindView(R.id.pb_details_loading_indicator)
    ProgressBar pbDetailsLoadingIndicator;
    @BindView(R.id.details_container_layout)
    LinearLayout detailsContainerLayout;
    @BindView(R.id.tv_user_company)
    TextView tvUserCompany;
    @BindView(R.id.tv_user_location)
    TextView tvUserLocation;
    @BindView(R.id.tv_user_email)
    TextView tvUserEmail;
    @BindView(R.id.tv_user_blog)
    TextView tvUserBlog;
    @BindView(R.id.tv_user_type)
    TextView tvUserType;
    @BindView(R.id.tv_user_followers)
    TextView tvUserFollowers;
    @BindView(R.id.tv_user_following)
    TextView tvUserFollowing;
    @BindView(R.id.tv_user_repos)
    TextView tvUserRepos;
    @BindView(R.id.tv_user_gists)
    TextView tvUserGists;
    @BindView(R.id.tv_user_registration_date)
    TextView tvUserRegistrationDate;
    @BindView(R.id.tv_user_update_date)
    TextView tvUserUpdateDate;
    @BindView(R.id.tv_user_hireable)
    TextView tvUserHireable;
    @BindView(R.id.tv_user_bio)
    TextView tvUserBio;

    private String username;
    private MainActivity mainActivity;
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
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        username = args.getString("username");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        ButterKnife.bind(this, view);
        mainActivity = (MainActivity) getActivity();

        ActionBar supportActionBar = mainActivity.getSupportActionBar();
        supportActionBar.setDisplayShowHomeEnabled(true);
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setTitle(username);
        return view;
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(getContext(),"Back button clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void setPresenter(DetailsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showUser(User user) {
        detailsContainerLayout.setVisibility(View.VISIBLE);
        tvUserCompany.setText(user.getCompany() == null ? "Company field is empty" : user.getCompany());
        tvUserLocation.setText(user.getLocation() == null ? "Location field is empty" : user.getLocation());
        tvUserEmail.setText(user.getEmail() == null ? "Email is private" : user.getEmail());
        tvUserBlog.setText(user.getBlog());
        tvUserType.setText(user.getType());
        tvUserFollowers.setText(Integer.toString(user.getFollowers()));
        tvUserFollowing.setText(Integer.toString(user.getFollowing()));
        tvUserRepos.setText(Integer.toString(user.getPublicRepos()));
        tvUserGists.setText(Integer.toString(user.getPublicGists()));
        tvUserRegistrationDate.setText(DateUtil.formatDate(user.getRegistrationDate()));
        tvUserUpdateDate.setText(DateUtil.formatDate(user.getUpdateDate()));
        tvUserHireable.setText(user.isHireable() ? "Yes, is hireable" : "Not at the moment");
        tvUserBio.setText(user.getBio() == null ? "Bio field is empty" : user.getBio());
    }

    @Override
    public void showLoadUserError() {
        Toast.makeText(getContext(), "Error while retrieving user", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setLoadingIndicator(boolean isLoading) {
        if (isLoading) {
            pbDetailsLoadingIndicator.setVisibility(View.VISIBLE);
        } else {
            pbDetailsLoadingIndicator.setVisibility(View.GONE);
        }
    }
}
