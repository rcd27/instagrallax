package com.githib.rcd27.instagrallax.data;


import android.support.annotation.NonNull;

import com.githib.rcd27.instagrallax.search.SearchUser;
import com.githib.rcd27.instagrallax.user.UserPost;

import java.util.List;

import io.reactivex.Observable;

public interface Model {

    Observable<String> getUserById(int id);

    Observable<List<SearchUser>> getSearchUserList(@NonNull String forQuery);

    Observable<List<UserPost>> getUserPosts(long id);

    Observable<String> getUserNameById(long id);

}
