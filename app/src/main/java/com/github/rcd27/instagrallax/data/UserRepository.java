package com.github.rcd27.instagrallax.data;


import android.support.annotation.NonNull;

import com.github.rcd27.instagrallax.net.InstagramApi;
import com.github.rcd27.instagrallax.search.SearchResultToSearchUsersMapper;
import com.github.rcd27.instagrallax.search.SearchUser;
import com.github.rcd27.instagrallax.user.UserMediaToUserPostsMapper;
import com.github.rcd27.instagrallax.user.UserPost;

import java.util.List;

import io.reactivex.Observable;

@SuppressWarnings("unchecked")
public class UserRepository extends BaseRepository {

    private final InstagramApi api;

    //TODO: тоже можно убрать в BaseRepository
    public UserRepository(InstagramApi api) {
        this.api = api;
    }

    @NonNull
    Observable<List<SearchUser>> getSearchUserList(@NonNull String forQuery) {
        return api.searchUser(forQuery)
                .map(new SearchResultToSearchUsersMapper())
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
