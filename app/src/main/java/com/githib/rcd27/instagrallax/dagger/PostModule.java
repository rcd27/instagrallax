package com.githib.rcd27.instagrallax.dagger;


import com.githib.rcd27.instagrallax.data.Model;
import com.githib.rcd27.instagrallax.post.PostContract;
import com.githib.rcd27.instagrallax.post.PostPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PostModule {
    private final PostContract.View view;

    public PostModule(PostContract.View view) {
        this.view = view;
    }

    @Provides
    PostContract.Presenter providePostPresenter(Model model) {
        return new PostPresenter(view, model);
    }
}
