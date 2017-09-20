package com.github.rcd27.instagrallax.data;


import com.github.rcd27.instagrallax.net.InstagramApi;
import com.github.rcd27.instagrallax.post.MediaDataToPostCommentsMapper;
import com.github.rcd27.instagrallax.post.PostComment;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@SuppressWarnings("unchecked")
public class PostRepository extends BaseRepository{

    private final InstagramApi api;

    public PostRepository(InstagramApi api) {
        this.api = api;
    }

    public Observable<List<PostComment>> getCommentsForPost(String postId) {
        return api.getCommentsForPost(postId)
                .map(new MediaDataToPostCommentsMapper())
                .compose(schedulersTransformer);
    }
}
