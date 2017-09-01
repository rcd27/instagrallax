package com.githib.rcd27.instagrallax.search;


import android.database.MatrixCursor;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;

public class SearchPresenter implements SearchContract.Presenter {

    private final SearchContract.View view;
    private final SearchContract.Model model;

    public SearchPresenter(SearchContract.View view) {
        this.view = view;
        this.model = new SearchModel();
    }

    @Override
    public MatrixCursor refreshSuggestions(@NonNull String query) {
        final MatrixCursor mc = new MatrixCursor(new String[]{BaseColumns._ID, "userName"});
        model.getSuggestions(query)
                .subscribe(suggestions -> {
                    for (int i = 0; i < suggestions.length; i++) {
                        if (suggestions[i].toLowerCase().startsWith(query.toLowerCase())) {
                            mc.addRow(new Object[]{i, suggestions[i]});
                        }
                    }
                });
        return mc;
    }
}
