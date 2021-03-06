package com.github.rcd27.instagrallax.user;

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

import com.github.rcd27.instagrallax.MagnettoApp;
import com.github.rcd27.instagrallax.R;
import com.github.rcd27.instagrallax.dagger.UserModule;
import com.github.rcd27.instagrallax.post.PostActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import static com.github.rcd27.instagrallax.post.PostActivity.IMAGE_URL;
import static com.github.rcd27.instagrallax.post.PostActivity.POST_ID;


public class UserActivity extends AppCompatActivity implements UserContract.View {

    public static final String USER_ID = "USER_ID";

    private RecyclerView recyclerView;

    @Inject
    public UserContract.Presenter presenter;
    private long currentUserId;

    @Inject
    public Picasso picasso;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        recyclerView = (RecyclerView) findViewById(R.id.activity_user_recycler_view);

        MagnettoApp.getInstance().getAppComponent().plus(new UserModule(this)).inject(this);

        currentUserId = getIntent().getExtras().getLong(USER_ID);
        presenter.setCurrentUserId(currentUserId);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        presenter.proceedUserName();
        presenter.proceedPosts();
    }

    @Override
    public void setAdapterForRecyclerView(List<UserPost> posts) {
        UserPostsAdapter userPostsAdapter = new UserPostsAdapter(picasso, presenter, posts);
        recyclerView.setAdapter(userPostsAdapter);
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
    public void startPostActivity(@NonNull String postId,
                                  @NonNull ImageView imageView,
                                  @NonNull String imageUrl) {
        Intent intent = new Intent(getApplicationContext(), PostActivity.class);
        intent.putExtra(POST_ID, postId);
        intent.putExtra(IMAGE_URL, imageUrl);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this, imageView, "sharedImageView"
        );
        startActivity(intent, options.toBundle());
    }
}
