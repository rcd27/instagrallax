package com.githib.rcd27.instagrallax.data;


import android.support.annotation.NonNull;
import android.util.SparseArray;

import java.util.Random;

import io.reactivex.Observable;

public class UserRepository {

    private static UserRepository instance;

    private final SparseArray<String> users = new SparseArray<>();

    private UserRepository() {
        String[] SUGGESTIONS = {
                "Иван Охлобыстин", "Андрей Кочергин", "Михаил Кокляев",
                "Сергий Алиев", "Федор Емельяненко", "Эд Халилов",
                "Сергей Бадюк", "Александр Невский", "Евгений Радионов", "Виталий Лебедь"
        };
        Random gimmeRandom = new Random();
        for (String s : SUGGESTIONS) {
            int randomID = Math.abs(gimmeRandom.nextInt());
            users.put(randomID, s);
        }
    }

    public static UserRepository getInstance() {
        if (null == instance) {
            instance = new UserRepository();
        }
        return instance;
    }

    public Observable<SparseArray<String>> getSuggestions(@NonNull String forQuery) {
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
