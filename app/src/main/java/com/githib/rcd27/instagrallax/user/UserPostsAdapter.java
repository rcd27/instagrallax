package com.githib.rcd27.instagrallax.user;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.githib.rcd27.instagrallax.R;
import com.squareup.picasso.Picasso;

import java.util.List;

class UserPostsAdapter extends RecyclerView.Adapter<UserPostsAdapter.ViewHolder> {

    private final Picasso picasso;

    UserPostsAdapter(Picasso picasso) {
        this.picasso = picasso;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View image = inflater.inflate(R.layout.activity_user_recycler_view_cell, parent, false);

        return new ViewHolder(image);
    }

    @Override
    public void onBindViewHolder(UserPostsAdapter.ViewHolder holder, int position) {
        picasso.load("https://avatars3.githubusercontent.com/u/20042955?v=4&s=460")
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.activity_user_recycler_view_cell_image_view);
        }
    }
}
