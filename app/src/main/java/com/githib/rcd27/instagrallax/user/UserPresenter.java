package com.githib.rcd27.instagrallax.user;


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
}
