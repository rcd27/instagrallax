package com.githib.rcd27.instagrallax.user;


import android.view.View;

import com.githib.rcd27.instagrallax.data.UserRepository;

class UserPresenter implements UserContract.Presenter {

    private final UserContract.View view;
    private final UserRepository userRepository;

    UserPresenter(UserContract.View view) {
        this.view = view;
        this.userRepository = UserRepository.getInstance();
    }

    @Override
    public void getUserNameById(int currentUserId) {
        userRepository.getUserById(currentUserId)
                .doOnError(throwable -> view.showError())
                .subscribe(view::setTitleForCurrentUser);
    }

    @Override
    public void onPostClicked(View clicked) {
        view.startPostActivity(1215224424);
    }
}
