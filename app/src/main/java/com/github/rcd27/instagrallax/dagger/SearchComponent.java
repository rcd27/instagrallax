package com.github.rcd27.instagrallax.dagger;

import com.github.rcd27.instagrallax.search.SearchActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {SearchModule.class})
public interface SearchComponent {

    void inject(SearchActivity searchActivity);

}
