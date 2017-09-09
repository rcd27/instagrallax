package com.githib.rcd27.instagrallax.post;


import android.support.annotation.NonNull;

import com.githib.rcd27.instagrallax.data.Model;

public class PostPresenter implements PostContract.Presenter {

    private final PostContract.View view;
    private final Model model;

    public PostPresenter(PostContract.View view, Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void procedeComments(@NonNull String postId) {
        model.getPostComments(postId)
                .subscribe(view::showComments);
    }
}
