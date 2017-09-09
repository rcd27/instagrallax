package com.githib.rcd27.instagrallax.dagger;


import com.githib.rcd27.instagrallax.post.PostActivity;

import dagger.Subcomponent;

@Subcomponent(modules = PostModule.class)
public interface PostComponent {

    void inject(PostActivity postActivity);
}
