package com.githib.rcd27.instagrallax.search;


import android.support.annotation.NonNull;

import io.reactivex.Observable;


class SearchModel implements SearchContract.Model {

    private static final String[] SUGGESTIONS = {
            "Вариант#1", "Вариант#2", "Вариант#3",
            "Не варинат", "Кукуруза", "арбуз",
            "Мыло", "верёвка", "КОмод", "стОл"
    };

    @Override
    public Observable<String[]> getSuggestions(@NonNull String forQuery) {
        return Observable.just(SUGGESTIONS);
    }

    @Override
    public Observable<String[]> getAllSuggetsions() {
        return Observable.just(SUGGESTIONS);
    }
}
