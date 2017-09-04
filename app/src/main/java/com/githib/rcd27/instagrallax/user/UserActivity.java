package com.githib.rcd27.instagrallax.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import com.githib.rcd27.instagrallax.R;
import com.githib.rcd27.instagrallax.post.PostActivity;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;


public class UserActivity extends AppCompatActivity implements UserContract.View {

    RecyclerView recyclerView;

    UserContract.Presenter presenter;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        recyclerView = (RecyclerView) findViewById(R.id.activity_user_recycler_view);
        presenter = new UserPresenter(this);

        Picasso picasso = new Picasso.Builder(getApplicationContext())
                .downloader(new OkHttp3Downloader(getApplicationContext(), 10 * 1024 * 1024))
                .build();
        UserPostsAdapter userPostsAdapter = new UserPostsAdapter(picasso, presenter);
        recyclerView.setAdapter(userPostsAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        int currentUserId = getIntent().getExtras().getInt("USER_ID");
        presenter.getUserNameById(currentUserId);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "N/A", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setTitleForCurrentUser(@NonNull String userName) {
        setTitle(userName);
    }

    @Override
    public void startPostActivity(int postId, @NonNull ImageView imageView, @NonNull String imageUrl) {
        Intent intent = new Intent(getApplicationContext(), PostActivity.class);
        intent.putExtra("POST_ID", postId);
        intent.putExtra("IMAGE_URL", imageUrl);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this, imageView, "sharedImageView"
        );
        startActivity(intent, options.toBundle());
    }
}
