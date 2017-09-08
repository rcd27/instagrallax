package com.githib.rcd27.instagrallax.dagger;


import com.githib.rcd27.instagrallax.data.Model;
import com.githib.rcd27.instagrallax.data.UserRepository;
import com.githib.rcd27.instagrallax.net.InstagramApi;
import com.githib.rcd27.instagrallax.data.SearchModel;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    Model provideModel(UserRepository userRepository) {
        return new SearchModel(userRepository);
    }

    @Provides
    UserRepository provideUserRepository(InstagramApi api) {
        return new UserRepository(api);
    }
}
