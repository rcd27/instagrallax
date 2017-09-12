package com.github.rcd27.instagrallax.post;


import android.support.annotation.NonNull;

import java.util.List;

public interface PostContract {

    interface View {
        void showComments(@NonNull List<PostComment> comments);
    }

    interface Presenter {
        void proceedComments(@NonNull String postId);
    }
}
