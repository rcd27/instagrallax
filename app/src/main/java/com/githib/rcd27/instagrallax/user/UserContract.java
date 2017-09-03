package com.githib.rcd27.instagrallax.user;


import android.support.annotation.NonNull;

interface UserContract {

    interface View {

        void showError();

        void setTitleForCurrentUser(@NonNull String userName);

        void startPostActivity(int postId);
    }

    interface Presenter {

        void getUserNameById(int currentUserId);

        void onPostClicked(android.view.View view);
    }
}
