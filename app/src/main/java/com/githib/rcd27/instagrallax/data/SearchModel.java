package com.githib.rcd27.instagrallax.data;


import android.support.annotation.NonNull;

import com.githib.rcd27.instagrallax.data.Model;
import com.githib.rcd27.instagrallax.data.UserRepository;
import com.githib.rcd27.instagrallax.search.SearchUser;
import com.githib.rcd27.instagrallax.user.UserPost;

import java.util.List;

import io.reactivex.Observable;


public class SearchModel implements Model {

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

    @Override
    public Observable<List<UserPost>> getUserPosts(long id) {
        return userRepository.getUserPosts(id);
    }

    @Override
    public Observable<String> getUserNameById(long id) {
        return userRepository.getUserNameById(id);
    }
}
