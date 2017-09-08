package com.githib.rcd27.instagrallax.dagger;

import com.githib.rcd27.instagrallax.user.UserActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {UserModule.class})
public interface UserComponent {

    void inject(UserActivity userActivity);

}
