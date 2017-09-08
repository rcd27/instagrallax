package com.githib.rcd27.instagrallax.dagger;


import com.githib.rcd27.instagrallax.data.Model;
import com.githib.rcd27.instagrallax.search.SearchContract;
import com.githib.rcd27.instagrallax.search.SearchPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class SearchModule {
    private final SearchContract.View view;

    public SearchModule(SearchContract.View view) {
        this.view = view;
    }

    @Provides
    SearchContract.Presenter provideSearchPresenter(Model model) {
        return new SearchPresenter(view, model);
    }
}
