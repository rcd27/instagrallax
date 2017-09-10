package com.githib.rcd27.instagrallax.data;


import android.support.annotation.NonNull;

import com.githib.rcd27.instagrallax.net.InstagramApi;
import com.githib.rcd27.instagrallax.search.SearchUser;
import com.githib.rcd27.instagrallax.search.SeachResultToSearchUsersMapper;
import com.githib.rcd27.instagrallax.user.UserMediaToUserPostsMapper;
import com.githib.rcd27.instagrallax.user.UserPost;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@SuppressWarnings("unchecked")
public class UserRepository {

    private final InstagramApi api;
    private final ObservableTransformer schedulersTransformer;

    public UserRepository(InstagramApi api) {
        this.api = api;
        schedulersTransformer = observable -> observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @NonNull
    Observable<List<SearchUser>> getSearchUserList(@NonNull String forQuery) {
        return api.searchUser(forQuery)
                .map(new SeachResultToSearchUsersMapper())
                .compose(schedulersTransformer);
    }

    @NonNull
    Observable<List<UserPost>> getUserPosts(long userId) {
        return api.getRecentMediaForUser(userId)
                .map(new UserMediaToUserPostsMapper())
                .compose(schedulersTransformer);
    }

    @NonNull
    Observable<String> getUserNameById(long id) {
        return api.getUserDataById(id)
                .map(userDataByID -> userDataByID.getData().getFull_name())
                .compose(schedulersTransformer);
    }
}
