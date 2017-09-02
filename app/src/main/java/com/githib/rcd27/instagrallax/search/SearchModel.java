package com.githib.rcd27.instagrallax.search;


import android.support.annotation.NonNull;
import android.util.SparseArray;

import com.githib.rcd27.instagrallax.data.UserRepository;

import io.reactivex.Observable;


class SearchModel implements SearchContract.Model {

    @Override
    public Observable<SparseArray<String>> getSuggestions(@NonNull String forQuery) {
        return UserRepository.getSuggestions(forQuery);
    }

    @Override
    public Observable<SparseArray<String>> getAllSuggestions() {
        return UserRepository.getAllSuggestions();
    }
}
