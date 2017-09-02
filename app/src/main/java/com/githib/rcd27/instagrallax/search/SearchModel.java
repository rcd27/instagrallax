package com.githib.rcd27.instagrallax.search;


import android.support.annotation.NonNull;
import android.util.SparseArray;

import java.util.Random;

import io.reactivex.Observable;


class SearchModel implements SearchContract.Model {

    private static final String[] SUGGESTIONS = {
            "Иван Охлобыстин", "Андрей Кочергин", "Михаил Кокляев",
            "Сергий Алиев", "Федор Емельяненко", "Эд Халилов",
            "Сергей Бадюк", "Александр Невский", "Евгений Радионов", "Виталий Лебедь"
    };

    private static final SparseArray<String> users = new SparseArray<>();

    static {
        Random gimmeRandom = new Random();
        for (String s : SUGGESTIONS) {
            int randomID = Math.abs(gimmeRandom.nextInt());
            users.put(randomID, s);
        }
    }

    @Override
    public Observable<SparseArray<String>> getSuggestions(@NonNull String forQuery) {
        return Observable.just(users);
    }

    @Override
    public Observable<SparseArray<String>> getAllSuggestions() {
        return Observable.just(users);
    }
}
