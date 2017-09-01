package com.githib.rcd27.instagrallax.search;


import android.database.MatrixCursor;
import android.provider.BaseColumns;
import android.support.annotation.Nullable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


class SearchPresenter implements SearchContract.Presenter {

    private final SearchContract.Model model;
    private final SearchContract.View view;

    public SearchPresenter(SearchContract.View view) {
        this.view = view;
        this.model = new SearchModel();
    }

    @Override
    public MatrixCursor refreshSuggestions(@Nullable String query) {
        final MatrixCursor mc = new MatrixCursor(new String[]{BaseColumns._ID, "userName"});
        if (null != query) {
            model.getSuggestions(query)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnError(throwable -> view.showError(throwable.getMessage()))
                    .subscribe(suggestions -> {
                        // TODO можно и маппер написать на это дело.
                        for (int i = 0; i < suggestions.length; i++) {
                            if (suggestions[i].toLowerCase().startsWith(query.toLowerCase())) {
                                mc.addRow(new Object[]{i, suggestions[i]});
                            }
                        }
                    });
            return mc;
        }
        // FIXME: не отрабатывает.
        model.getAllSuggetsions()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(throwable -> view.showError(throwable.getMessage()))
                .subscribe(suggestions -> {
                    for (int i = 0; i < suggestions.length; i++) {
                        mc.addRow(new Object[]{i, suggestions[i]});
                    }
                });
        return mc;
    }

    @Override
    public void goToUserIfExists(@Nullable String query) {
        if (null != query) {
            /* Логика проверки существования юзера */
            view.showUser(query);
        } else {
            view.showError("Search query must not be null");
        }
    }
}
