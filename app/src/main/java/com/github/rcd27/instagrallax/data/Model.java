package com.github.rcd27.instagrallax.data;


import android.support.annotation.NonNull;

import com.github.rcd27.instagrallax.post.PostComment;
import com.github.rcd27.instagrallax.search.SearchUser;
import com.github.rcd27.instagrallax.user.UserPost;

import java.util.List;

import io.reactivex.Observable;

public interface Model {

    Observable<List<SearchUser>> getSearchUserList(@NonNull String forQuery);

    Observable<List<UserPost>> getUserPosts(long id);

    Observable<String> getUserNameById(long id);

    Observable<List<PostComment>> getPostComments(@NonNull String postId);

}
