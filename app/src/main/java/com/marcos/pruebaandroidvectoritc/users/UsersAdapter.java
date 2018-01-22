package com.marcos.pruebaandroidvectoritc.users;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.marcos.pruebaandroidvectoritc.R;
import com.marcos.pruebaandroidvectoritc.data.User;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;

/**
 * Created by markc on 22/01/2018.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

    List<User> users;
    Context context;

    public UsersAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = users.get(position);

        holder.tvUserName.setText(user.getName());
        holder.tvUserUrl.setText(user.getUrl());
        Picasso.with(context)
                .load(user.getGravatarUrl())
                .into(holder.ivUserAvatar);

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public User user;

        @BindView(R.id.iv_user_avatar)
        ImageView ivUserAvatar;

        @BindView(R.id.tv_user_name)
        TextView tvUserName;

        @BindView(R.id.tv_user_url)
        TextView tvUserUrl;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
