package com.githib.rcd27.instagrallax.user;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.githib.rcd27.instagrallax.R;
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
        UserPostsAdapter userPostsAdapter = new UserPostsAdapter(picasso);
        recyclerView.setAdapter(userPostsAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
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
}
