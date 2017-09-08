package com.githib.rcd27.instagrallax.search;


import android.support.annotation.NonNull;
import android.util.SparseArray;

import com.githib.rcd27.instagrallax.data.UserRepository;

import java.util.List;

import io.reactivex.Observable;


public class SearchModel implements SearchContract.Model {

    private final UserRepository userRepository;

    public SearchModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Observable<String> getUserById(int id) {
        return null;
    }

    @Override
    public Observable<List<SearchUser>> getSearchUserList(@NonNull String forQuery) {
        return userRepository.getSearchUserList(forQuery);
    }
}
