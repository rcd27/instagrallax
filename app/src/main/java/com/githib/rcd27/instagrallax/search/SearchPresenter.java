package com.githib.rcd27.instagrallax.search;


import android.database.MatrixCursor;
import android.provider.BaseColumns;
import android.support.annotation.Nullable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class SearchPresenter implements SearchContract.Presenter {

    private final SearchContract.Model model;
    private final SearchContract.View view;

    public SearchPresenter(SearchContract.View view, SearchContract.Model model) {
        this.view = view;
        this.model = model;
    }

    // TODO тут выполняется по сути работа FilterQueryProvider. Изучить.
    @Override
    public MatrixCursor getCursorFor(@Nullable String query) {
        // FIXME поиск отрабатывает, нужный курсор возвращается, но UI не отображает
        final MatrixCursor mc = new MatrixCursor(new String[]{BaseColumns._ID, "instId", "userName"});
        if (null != query) {
            model.getSearchUserList(query)
                    // TODO перенести в Transformer
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(searchUsers -> {
                        for (int i = 0; i < searchUsers.size(); i++) {
                            //TODO перенести фильтрацию в Model слой
                            SearchUser currentUser = searchUsers.get(i);
                            if (currentUser.getFullName().toLowerCase().startsWith(query.toLowerCase())) {
                                mc.addRow(new Object[]{i, currentUser.getId(), currentUser.getFullName()});
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
            view.showError("No such user");
        } else {
            view.showError("Search query must not be null");
        }
    }
}
