package com.githib.rcd27.instagrallax.user;


import android.support.annotation.NonNull;
import android.widget.ImageView;

interface UserContract {

    interface View {

        void showError();

        void setTitleForCurrentUser(@NonNull String userName);

        void startPostActivity(int postId, @NonNull ImageView imageView, @NonNull String imageUrl);
    }

    interface Presenter {

        void getUserNameById(int currentUserId);

        void onPostClicked(int postId, @NonNull ImageView view, @NonNull String imageUrl);
    }
}
