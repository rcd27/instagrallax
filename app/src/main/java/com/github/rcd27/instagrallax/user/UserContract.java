package com.github.rcd27.instagrallax.user;


import android.support.annotation.NonNull;
import android.widget.ImageView;

import java.util.List;

public interface UserContract {

    interface View {

        void setAdapterForRecyclerView(List<UserPost> posts);

        void showError();

        void setTitleForCurrentUser(@NonNull String userName);

        void startPostActivity(@NonNull String postId, @NonNull ImageView imageView, @NonNull String imageUrl);
    }

    interface Presenter {

        void setCurrentUserId(long id);

        void proceedUserName();

        void onPostClicked(@NonNull String postId, @NonNull ImageView imageView, @NonNull String imageUrl);

        void proceedPosts();
    }
}
