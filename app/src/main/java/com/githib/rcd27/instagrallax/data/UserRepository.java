package com.githib.rcd27.instagrallax.data;


import android.support.annotation.NonNull;
import android.util.SparseArray;

import com.githib.rcd27.instagrallax.net.InstagramApi;

import java.util.Random;

import io.reactivex.Observable;

public class UserRepository {

    private final InstagramApi api;
    private final SparseArray<String> users = new SparseArray<>();

    public UserRepository(InstagramApi api) {
        this.api = api;

        String[] SUGGESTIONS = {
                "Иван Охлобыстин", "Андрей Кочергин", "Михаил Кокляев",
                "Сергий Алиев", "Федор Емельяненко", "Эд Халилов",
                "Сергей Бадюк", "Александр Невский", "Евгений Радионов", "Анатолий Лебедь"
        };
        Random gimmeRandom = new Random();
        for (String s : SUGGESTIONS) {
            int randomID = Math.abs(gimmeRandom.nextInt());
            users.put(randomID, s);
        }
    }

    public Observable<SparseArray<String>> getMockSuggestions(@NonNull String forQuery) {
        return Observable.just(users);
    }

    public Observable<SparseArray<String>> getAllSuggestions() {
        return Observable.just(users);
    }

    public Observable<String> getUserById(int id) {
        String result = users.get(id);
        if (null != result) {
            return Observable.just(users.get(id));
        }
        return Observable.just("N/A");
    }
}
