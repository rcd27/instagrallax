package com.githib.rcd27.instagrallax.user;


import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.githib.rcd27.instagrallax.data.Model;

public class UserPresenter implements UserContract.Presenter {

    private final UserContract.View view;
    private final Model model;
    private long currentUserId;

    @Override
    public void setCurrentUserId(long id) {
        this.currentUserId = id;
    }

    public UserPresenter(@NonNull UserContract.View view,@NonNull Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void proceedUserName() {
        model.getUserNameById(currentUserId)
                .subscribe(view::setTitleForCurrentUser);
    }

    @Override
    public void proceedPosts() {
        model.getUserPosts(currentUserId)
                .subscribe(view::setAdapterForRecyclerView);
    }

    @Override
    public void onPostClicked(@NonNull String postId,
                              // FIXME переделать на ResId
                              @NonNull ImageView clicked,
                              @NonNull String imageUrl) {
        view.startPostActivity(postId, clicked, imageUrl);
    }
}
