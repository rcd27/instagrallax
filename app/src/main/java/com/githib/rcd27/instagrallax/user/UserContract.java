package com.githib.rcd27.instagrallax.user;


import android.support.annotation.NonNull;
import android.widget.ImageView;

import java.util.List;

import io.reactivex.Observable;

public interface UserContract {

    interface View {

        void showError();

        void setTitleForCurrentUser(@NonNull String userName);

        void startPostActivity(String postId, @NonNull ImageView imageView, @NonNull String imageUrl);
    }

    interface Presenter {

        void setCurrentUserId(long id);

        Observable<List<UserPost>> getUserPosts();

        void procedeUserName();

        void onPostClicked(String postId, @NonNull ImageView view, @NonNull String imageUrl);
    }
}
