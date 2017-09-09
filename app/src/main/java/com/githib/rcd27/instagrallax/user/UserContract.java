package com.githib.rcd27.instagrallax.user;


import android.support.annotation.NonNull;
import android.widget.ImageView;

import java.util.List;

public interface UserContract {

    interface View {

        void setAdapterForRecyclerView(List<UserPost> posts);

        void showError();

        void setTitleForCurrentUser(@NonNull String userName);

        void startPostActivity(String postId, @NonNull ImageView imageView, @NonNull String imageUrl);
    }

    interface Presenter {

        void setCurrentUserId(long id);

        void procedeUserName();

        void onPostClicked(String postId, @NonNull ImageView view, @NonNull String imageUrl);

        void procedePosts();
    }
}
