package com.githib.rcd27.instagrallax.user;


import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.githib.rcd27.instagrallax.data.Model;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserPresenter implements UserContract.Presenter {

    private final UserContract.View view;
    private final Model model;
    private long currentUserId;

    @Override
    public void setCurrentUserId(long id) {
        this.currentUserId = id;
    }

    public UserPresenter(UserContract.View view, Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void procedeUserName() {
        model.getUserNameById(currentUserId)
                .subscribe(view::setTitleForCurrentUser);
    }

    @Override
    public void procedePosts() {
        model.getUserPosts(currentUserId)
                .subscribe(view::setAdapterForRecyclerView);
    }

    @Override
    public void onPostClicked(String postId, @NonNull ImageView clicked, @NonNull String imageUrl) {
        view.startPostActivity(postId, clicked, imageUrl);
    }
}
