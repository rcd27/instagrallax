package com.githib.rcd27.instagrallax.user;


import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.githib.rcd27.instagrallax.data.UserRepository;

class UserPresenter implements UserContract.Presenter {

    private final UserContract.View view;
    private final UserRepository userRepository;

    UserPresenter(UserContract.View view) {
        this.view = view;
        // FIXME
        this.userRepository = new UserRepository(null);
    }

    @Override
    public void getUserNameById(int currentUserId) {
        userRepository.getFakeUserById(currentUserId)
                .doOnError(throwable -> view.showError())
                .subscribe(view::setTitleForCurrentUser);
    }

    @Override
    public void onPostClicked(int postId, @NonNull ImageView clicked, @NonNull String imageUrl) {
        view.startPostActivity(postId, clicked, imageUrl);
    }
}
