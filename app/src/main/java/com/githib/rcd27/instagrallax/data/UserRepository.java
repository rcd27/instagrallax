package com.githib.rcd27.instagrallax.data;


import android.support.annotation.NonNull;

import com.githib.rcd27.instagrallax.MagnettoApp;
import com.githib.rcd27.instagrallax.net.InstagramApi;
import com.githib.rcd27.instagrallax.search.SearchUser;
import com.githib.rcd27.instagrallax.search.SearchUserMapper;
import com.githib.rcd27.instagrallax.user.UserPost;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.SingleTransformer;
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

    public Observable<List<SearchUser>> getSearchUserList(@NonNull String forQuery) {
        // TODO убрать access_token вниз
        return api.searchUser(forQuery, MagnettoApp.ACCESS_TOKEN)
                .map(new SearchUserMapper())
                .compose(schedulersTransformer);
    }

    public Observable<List<UserPost>> getUserPosts(long userId) {
        return api.getRecentMediaForUser(userId, MagnettoApp.ACCESS_TOKEN)
                .map(new UserMediaToUserPostsMapper())
                .compose(schedulersTransformer);
    }

    public Observable<String> getUserNameById(long id) {
        return api.getUserDataById(id, MagnettoApp.ACCESS_TOKEN)
                .map(userDataByID -> userDataByID.getData().getFull_name())
                .compose(schedulersTransformer);
    }
}
