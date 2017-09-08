package com.githib.rcd27.instagrallax.search;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.githib.rcd27.instagrallax.data.Model;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class SearchPresenter implements SearchContract.Presenter {

    private final SearchContract.View view;
    private final Model model;

    public SearchPresenter(SearchContract.View view, Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void goToUserIfExists(@Nullable String query) {
        if (null != query) {
            view.showError("No such user");
        } else {
            view.showError("Search query must not be null");
        }
    }

    @Override
    public void procedeUserSearch(@NonNull String query) {
        model.getSearchUserList(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::showSuggestions);
    }
}
