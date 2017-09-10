package com.githib.rcd27.instagrallax.data;


import android.support.annotation.NonNull;

import com.githib.rcd27.instagrallax.post.PostComment;
import com.githib.rcd27.instagrallax.search.SearchUser;
import com.githib.rcd27.instagrallax.user.UserPost;

import java.util.List;

import io.reactivex.Observable;


public class MainModel implements Model {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public MainModel(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @NonNull
    @Override
    public Observable<List<SearchUser>> getSearchUserList(@NonNull String forQuery) {
        return userRepository.getSearchUserList(forQuery);
    }

    @NonNull
    @Override
    public Observable<List<UserPost>> getUserPosts(long id) {
        return userRepository.getUserPosts(id);
    }

    @NonNull
    @Override
    public Observable<String> getUserNameById(long id) {
        return userRepository.getUserNameById(id);
    }

    @Override
    public Observable<List<PostComment>> getPostComments(@NonNull String postId) {
        return postRepository.getCommentsForPost(postId);
    }
}
