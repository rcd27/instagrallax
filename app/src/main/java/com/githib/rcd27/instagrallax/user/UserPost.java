package com.githib.rcd27.instagrallax.user;

import com.githib.rcd27.instagrallax.VisualObject;

import java.util.List;

@VisualObject
public class UserPost {
    private final String id;
    private final List<PostImage> images;

    public UserPost(String id, List<PostImage> images) {
        this.id = id;
        this.images = images;
    }

    public String getId() {
        return id;
    }

    public PostImage getThumbnail() {
        for (PostImage pi : images) {
            if (pi.category.equals(UserMediaToUserPostsMapper.THUMBNAIL))
                return pi;
        }
        return new PostImage("no image", 0, 0, "https://avatars3.githubusercontent.com/u/20042955?v=4&s=460");
    }

    public PostImage getStandart() {
        for (PostImage pi : images) {
            if (pi.category.equals(UserMediaToUserPostsMapper.STANDERT_RESOLUTION)) {
                return pi;
            }
        }
        return new PostImage("no image", 0, 0, "https://avatars3.githubusercontent.com/u/20042955?v=4&s=460");
    }

    public PostImage getLowResolution() {
        for (PostImage pi : images) {
            if (pi.category.equals(UserMediaToUserPostsMapper.STANDERT_RESOLUTION)) {
                return pi;
            }
        }
        return new PostImage("no image", 0, 0, "https://avatars3.githubusercontent.com/u/20042955?v=4&s=460");
    }
}
