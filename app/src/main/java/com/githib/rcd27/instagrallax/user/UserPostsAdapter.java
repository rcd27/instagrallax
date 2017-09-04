package com.githib.rcd27.instagrallax.user;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.githib.rcd27.instagrallax.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

class UserPostsAdapter extends RecyclerView.Adapter<UserPostsAdapter.ViewHolder> {

    private final Picasso picasso;
    private final UserContract.Presenter presenter;

    private List<String> posts = new ArrayList<String>() {{
        add("https://avatars3.githubusercontent.com/u/20042955?v=4&s=460");
        add("https://upload.wikimedia.org/wikipedia/en/a/a6/Bender_Rodriguez.png");
        add("https://vignette3.wikia.nocookie.net/en.futurama/images/7/70/BenderTheOffender.jpg/revision/latest?cb=20110614181253");
        add("http://static.tvfanatic.com/images/gallery/bender-smoking.jpg");
        add("https://pbs.twimg.com/profile_images/1207791845/bender.gif");
        add("http://www.prorobot.ru/gallery/foto/11110044536.jpg");
        add("https://vignette1.wikia.nocookie.net/en.futurama/images/5/5b/I%27m_40%25_Bender/revision/latest?cb=20140722150206");
        add("https://avatanplus.com/files/resources/mid/583a117a78fc5158a2d44680.png");
    }};

    UserPostsAdapter(Picasso picasso, UserContract.Presenter presenter) {
        this.picasso = picasso;
        this.presenter = presenter;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View image = inflater.inflate(R.layout.activity_user_recycler_view_cell, parent, false);
        return new ViewHolder(image);
    }

    @Override
    public void onBindViewHolder(UserPostsAdapter.ViewHolder holder, int position) {
        String imageUrl = posts.get(position); //                              ↑
        picasso.load(imageUrl)                 //                              ↑
                .into(holder.imageView);       //                              ↑
        //                 ↓**********************warning about position : int ↑
        holder.postId = position;
        holder.imageUrl = imageUrl;
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        int postId;
        String imageUrl;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.activity_user_recycler_view_cell_image_view);
            imageView.setOnClickListener(imageView ->
                    presenter.onPostClicked(postId, this.imageView, this.imageUrl));
        }
    }
}
