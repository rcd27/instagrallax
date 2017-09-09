package com.githib.rcd27.instagrallax.data;


import com.githib.rcd27.instagrallax.net.InstagramApi;
import com.githib.rcd27.instagrallax.post.MediaDataToPostCommentsMapper;
import com.githib.rcd27.instagrallax.post.PostComment;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@SuppressWarnings("unchecked")
public class PostRepository {

    private final InstagramApi api;
    private final ObservableTransformer schedulersTransformer;

    public PostRepository(InstagramApi api) {
        this.api = api;
        schedulersTransformer = observable -> observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<List<PostComment>> getCommentsForPost(String postId) {
        return api.getCommentsForPost(postId)
                .compose(schedulersTransformer);
    }
}
