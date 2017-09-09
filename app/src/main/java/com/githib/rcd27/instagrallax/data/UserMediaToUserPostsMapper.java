package com.githib.rcd27.instagrallax.data;


import com.githib.rcd27.instagrallax.net.UserRecentMedia;
import com.githib.rcd27.instagrallax.user.PostImage;
import com.githib.rcd27.instagrallax.user.UserPost;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class UserMediaToUserPostsMapper implements Function<UserRecentMedia, List<UserPost>> {
    public static final String THUMBNAIL = "thumbnail";
    public static final String LOW_RESOLUTION = "lowResolution";
    public static final String STANDERT_RESOLUTION = "standartResolution";

    @Override
    public List<UserPost> apply(@NonNull UserRecentMedia userRecentMedia) throws Exception {
        List<UserPost> result = new ArrayList<>();
        List<UserRecentMedia.Data> dto = userRecentMedia.getData();
        for (UserRecentMedia.Data currentData : dto) {
            String currentDataId = currentData.getId();

            UserRecentMedia.Images dtoImages = currentData.getImages();
            int thumbnialWidth = dtoImages.getThumbnail().getWidth();
            int thumbnailHeight = dtoImages.getThumbnail().getHeight();
            String thumbnailUrl = dtoImages.getThumbnail().getUrl();

            int lowResolutionWidth = dtoImages.getLowResolution().getWidth();
            int lowResolutionHeight = dtoImages.getLowResolution().getHeight();
            String lowResolutionUrl = dtoImages.getLowResolution().getUrl();

            int standartResolutionWidth = dtoImages.getStandardResolution().getWidth();
            int standartResolutionHeight = dtoImages.getStandardResolution().getHeight();
            String standartResolutionUrl = dtoImages.getStandardResolution().getUrl();

            List<PostImage> postImages = new ArrayList<>();
            postImages.add(new PostImage(THUMBNAIL, thumbnialWidth, thumbnailHeight, thumbnailUrl));
            postImages.add(new PostImage(LOW_RESOLUTION, lowResolutionWidth, lowResolutionHeight, lowResolutionUrl));
            postImages.add(new PostImage(STANDERT_RESOLUTION, standartResolutionWidth, standartResolutionHeight, standartResolutionUrl));

            result.add(new UserPost(currentDataId, postImages));
        }
        return result;
    }
}
