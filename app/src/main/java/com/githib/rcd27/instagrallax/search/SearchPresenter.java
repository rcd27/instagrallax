package com.githib.rcd27.instagrallax.search;


import android.support.annotation.NonNull;

import com.githib.rcd27.instagrallax.data.Model;


public class SearchPresenter implements SearchContract.Presenter {

    private final SearchContract.View view;
    private final Model model;

    public SearchPresenter(SearchContract.View view, Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void procedeUserSearch(@NonNull String query) {
        model.getSearchUserList(query)
                .subscribe(view::showSuggestions);
    }
}
