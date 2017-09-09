package com.githib.rcd27.instagrallax.dagger;


import android.content.Context;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;

import com.githib.rcd27.instagrallax.R;
import com.githib.rcd27.instagrallax.data.Model;
import com.githib.rcd27.instagrallax.search.SearchActivity;
import com.githib.rcd27.instagrallax.search.SearchContract;
import com.githib.rcd27.instagrallax.search.SearchPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class SearchModule {
    private final SearchContract.View view;
    private final Context searchActivityContext;

    public SearchModule(SearchContract.View view, Context searchActivityContext) {
        this.view = view;
        this.searchActivityContext = searchActivityContext;
    }

    @Provides
    SearchContract.Presenter provideSearchPresenter(Model model) {
        return new SearchPresenter(view, model);
    }

    @Provides
    SimpleCursorAdapter provideCursorAdapter() {
        return new SimpleCursorAdapter(
                searchActivityContext,
                R.layout.support_simple_spinner_dropdown_item,
                null,
                new String[]{SearchActivity.CURSOR_USER_NAME},
                new int[]{android.R.id.text1},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        );
    }
}
