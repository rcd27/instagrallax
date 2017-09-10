package com.githib.rcd27.instagrallax.user;

import android.support.annotation.NonNull;

import com.githib.rcd27.instagrallax.data.UserMediaToUserPostsMapper;

import java.util.List;

public class UserPost {
    private final String id;
    private final List<PostImage> images;

    public UserPost(@NonNull String id, @NonNull List<PostImage> images) {
        this.id = id;
        this.images = images;
    }

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public PostImage getThumbnail() {
        for (PostImage pi : images) {
            if (pi.category.equals(UserMediaToUserPostsMapper.THUMBNAIL))
                return pi;
        }
        return new PostImage("no image", 0, 0, "https://avatars3.githubusercontent.com/u/20042955?v=4&s=460");
    }

    @NonNull
    public PostImage getStandart() {
        for (PostImage pi : images) {
            if (pi.category.equals(UserMediaToUserPostsMapper.STANDERT_RESOLUTION)) {
                return pi;
            }
        }
        return new PostImage("no image", 0, 0, "https://avatars3.githubusercontent.com/u/20042955?v=4&s=460");
    }

    @NonNull
    public PostImage getLowResolution() {
        for (PostImage pi : images) {
            if (pi.category.equals(UserMediaToUserPostsMapper.STANDERT_RESOLUTION)) {
                return pi;
            }
        }
        return new PostImage("no image", 0, 0, "https://avatars3.githubusercontent.com/u/20042955?v=4&s=460");
    }
}
