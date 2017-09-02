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

    // TODO тут выполняется по сути работа FilterQueryProvider. Изучить.
    @Override
    public MatrixCursor getCursorFor(@Nullable String query) {
        final MatrixCursor mc = new MatrixCursor(new String[]{BaseColumns._ID, "instId", "userName"});
        if (null != query) {
            model.getSuggestions(query)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnError(throwable -> view.showError(throwable.getMessage()))
                    .subscribe(users -> {
                        for (int i = 0; i < users.size(); i++) {
                            int currentKey = users.keyAt(i);
                            String currentUser = users.get(currentKey);
                            if (currentUser.toLowerCase().startsWith(query.toLowerCase())) {
                                mc.addRow(new Object[]{i, currentKey, currentUser});
                            }
                        }
                    });
            return mc;
        }
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
