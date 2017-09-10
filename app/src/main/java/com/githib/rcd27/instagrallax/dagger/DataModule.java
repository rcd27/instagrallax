package com.githib.rcd27.instagrallax.dagger;


import com.githib.rcd27.instagrallax.data.MainModel;
import com.githib.rcd27.instagrallax.data.Model;
import com.githib.rcd27.instagrallax.data.PostRepository;
import com.githib.rcd27.instagrallax.data.UserRepository;
import com.githib.rcd27.instagrallax.net.InstagramApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    @Singleton
    Model provideModel(UserRepository userRepository, PostRepository postRepository) {
        return new MainModel(userRepository, postRepository);
    }

    @Provides
    @Singleton
    UserRepository provideUserRepository(InstagramApi api) {
        return new UserRepository(api);
    }

    @Provides
    PostRepository providePostRepository(InstagramApi api) {
        return new PostRepository(api);
    }
}
