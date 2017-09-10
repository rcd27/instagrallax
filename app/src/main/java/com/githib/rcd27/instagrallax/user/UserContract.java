package com.githib.rcd27.instagrallax.user;


import android.support.annotation.IdRes;
import android.support.annotation.NonNull;

import java.util.List;

public interface UserContract {

    interface View {

        void setAdapterForRecyclerView(List<UserPost> posts);

        void showError();

        void setTitleForCurrentUser(@NonNull String userName);

        void startPostActivity(String postId, @IdRes int imageViewId, @NonNull String imageUrl);
    }

    interface Presenter {

        void setCurrentUserId(long id);

        void proceedUserName();

        void onPostClicked(@NonNull String postId, @IdRes int imageViewId, @NonNull String imageUrl);

        void proceedPosts();
    }
}
