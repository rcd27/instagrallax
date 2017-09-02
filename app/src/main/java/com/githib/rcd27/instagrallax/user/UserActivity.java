package com.githib.rcd27.instagrallax.user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.githib.rcd27.instagrallax.R;
import com.githib.rcd27.instagrallax.data.UserRepository;


public class UserActivity extends AppCompatActivity {

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        //TODO поменять на int
        int currentUserId = 0;
        try {
            currentUserId = Integer.parseInt(getIntent().getExtras().getString("USER_ID"));
        } catch (NumberFormatException e) {
            showError();
        }
        UserRepository.getUserById(currentUserId)
                .doOnError(throwable -> showError())
                .subscribe(this::setTitle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    void showError() {
        Toast.makeText(this, "N/A", Toast.LENGTH_SHORT).show();
    }
}
