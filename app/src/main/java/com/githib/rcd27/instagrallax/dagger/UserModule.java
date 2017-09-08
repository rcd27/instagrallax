package com.githib.rcd27.instagrallax.dagger;

import com.githib.rcd27.instagrallax.data.Model;
import com.githib.rcd27.instagrallax.user.UserContract;
import com.githib.rcd27.instagrallax.user.UserPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {
    private final UserContract.View view;


    public UserModule(UserContract.View view) {
        this.view = view;
    }

    @Provides
    UserContract.Presenter providePresenter(Model model) {
        return new UserPresenter(view, model);
    }
}
