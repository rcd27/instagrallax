package com.github.rcd27.instagrallax.dagger;


import com.github.rcd27.instagrallax.post.PostActivity;

import dagger.Subcomponent;

@Subcomponent(modules = PostModule.class)
public interface PostComponent {

    void inject(PostActivity postActivity);

}
