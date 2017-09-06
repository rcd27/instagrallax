package com.githib.rcd27.instagrallax.dagger;

import com.githib.rcd27.instagrallax.search.SearchActivity;

import dagger.Subcomponent;

@Subcomponent(modules = SearchModule.class)
public interface SearchComponent {

    void inject(SearchActivity searchActivity);

}
