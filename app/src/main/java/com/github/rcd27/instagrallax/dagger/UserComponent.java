package com.github.rcd27.instagrallax.dagger;

import com.github.rcd27.instagrallax.user.UserActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {UserModule.class})
public interface UserComponent {

    void inject(UserActivity userActivity);

}
