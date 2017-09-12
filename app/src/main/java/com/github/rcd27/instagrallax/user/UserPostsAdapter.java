package com.github.rcd27.instagrallax.user;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.rcd27.instagrallax.R;
import com.squareup.picasso.Picasso;

import java.util.List;

class UserPostsAdapter extends RecyclerView.Adapter<UserPostsAdapter.ViewHolder> {

    private final Picasso picasso;
    private final UserContract.Presenter presenter;
    private final List<UserPost> userPosts;

    public UserPostsAdapter(@NonNull Picasso picasso,
                            @NonNull UserContract.Presenter presenter,
                            @NonNull List<UserPost> posts) {
        this.picasso = picasso;
        this.presenter = presenter;
        this.userPosts = posts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View image = inflater.inflate(R.layout.activity_user_recycler_view_cell, parent, false);
        return new ViewHolder(image);
    }

    @Override
    public void onBindViewHolder(UserPostsAdapter.ViewHolder holder, int position) {
        UserPost currentPost = userPosts.get(position);
        String lowResolution = currentPost.getLowResolution().url;
        picasso.load(lowResolution)
                .into(holder.imageView);
        holder.postId = currentPost.getId();
        holder.thumbnailUrl = currentPost.getThumbnail().url;
        holder.lowResolutionUrl = lowResolution;
        holder.standardResolutionUrl = currentPost.getStandard().url;
    }

    @Override
    public int getItemCount() {
        return userPosts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        String postId;
        String thumbnailUrl;
        String lowResolutionUrl;
        String standardResolutionUrl;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.activity_user_recycler_view_cell_image_view);
            imageView.setOnClickListener(image ->
                    presenter.onPostClicked(postId, this.imageView, this.standardResolutionUrl));
        }
    }
}
