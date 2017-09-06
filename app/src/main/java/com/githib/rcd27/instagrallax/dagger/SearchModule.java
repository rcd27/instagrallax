package com.githib.rcd27.instagrallax.dagger;


import com.githib.rcd27.instagrallax.data.UserRepository;
import com.githib.rcd27.instagrallax.net.InstagramApi;
import com.githib.rcd27.instagrallax.search.SearchContract;
import com.githib.rcd27.instagrallax.search.SearchModel;
import com.githib.rcd27.instagrallax.search.SearchPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Singleton
@Module
public class SearchModule {
    private final SearchContract.View view;

    public SearchModule(SearchContract.View view) {
        this.view = view;
    }

    @Provides
    SearchContract.Presenter provideSearchPresenter(SearchContract.Model model) {
        return new SearchPresenter(view, model);
    }

    @Provides
    SearchContract.Model provideModel(UserRepository userRepository) {
        return new SearchModel(userRepository);
    }

    //TODO вынести в отдельный DataModule
    @Provides
    UserRepository provideUserRepository(InstagramApi api) {
        return new UserRepository(api);
    }
}
