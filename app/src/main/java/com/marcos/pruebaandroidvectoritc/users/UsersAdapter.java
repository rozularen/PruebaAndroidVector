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
import com.marcos.pruebaandroidvectoritc.util.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by markc on 22/01/2018.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

    private final ItemClickListener itemClickListener;
    List<User> users;
    Context context;

    public UsersAdapter(Context context, ItemClickListener itemClickListener, List<User> users) {
        this.context = context;
        this.itemClickListener = itemClickListener;
        this.users = users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(view, itemClickListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = users.get(position);

        holder.user = user;

        holder.tvUserName.setText(user.getName());
        holder.tvUserUrl.setText(user.getUrl());
        Picasso.with(context)
                .load(user.getGravatarUrl())
                .transform(new CircleTransform())
                .into(holder.ivUserAvatar);

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public interface ItemClickListener {
        void onClick(View view, String username);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ItemClickListener itemClickListener;
        private String username;
        public User user;

        @BindView(R.id.iv_user_avatar)
        ImageView ivUserAvatar;

        @BindView(R.id.tv_user_name)
        TextView tvUserName;

        @BindView(R.id.tv_user_url)
        TextView tvUserUrl;

        public ViewHolder(View itemView, ItemClickListener itemClickListener) {
            super(itemView);
            this.itemClickListener = itemClickListener;
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            username = user.getName();
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view, username);
        }
    }
}
