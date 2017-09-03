package com.githib.rcd27.instagrallax.post;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.githib.rcd27.instagrallax.R;
import com.githib.rcd27.instagrallax.data.PostRepository;

import java.util.List;

class PostRecyclerViewAdapter extends RecyclerView.Adapter<PostRecyclerViewAdapter.ViewHolder> {

    private List<String> posts;

    PostRecyclerViewAdapter() {
        this.posts = PostRepository.getInstance().getComments();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View textItem = inflater.inflate(R.layout.activity_post_recycler_view_cell, parent);
        return new ViewHolder(textItem);
    }

    @Override
    public void onBindViewHolder(PostRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.textView.setText(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.activity_post_recycler_view_cell_text_view);
        }
    }
}
