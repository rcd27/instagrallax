package com.github.rcd27.instagrallax.user;


import com.github.rcd27.instagrallax.net.UserRecentMediaDTO;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class UserMediaToUserPostsMapper implements Function<UserRecentMediaDTO, List<UserPost>> {
    public static final String THUMBNAIL = "thumbnail";
    public static final String LOW_RESOLUTION = "lowResolution";
    public static final String STANDERT_RESOLUTION = "standardResolution";

    @Override
    public List<UserPost> apply(@NonNull UserRecentMediaDTO userRecentMediaDTO) throws Exception {
        List<UserPost> result = new ArrayList<>();
        List<UserRecentMediaDTO.Data> dto = userRecentMediaDTO.getData();
        for (UserRecentMediaDTO.Data currentData : dto) {
            String currentDataId = currentData.getId();

            UserRecentMediaDTO.Images dtoImages = currentData.getImages();
            int thumbnialWidth = dtoImages.getThumbnail().getWidth();
            int thumbnailHeight = dtoImages.getThumbnail().getHeight();
            String thumbnailUrl = dtoImages.getThumbnail().getUrl();

            int lowResolutionWidth = dtoImages.getLow_resolution().getWidth();
            int lowResolutionHeight = dtoImages.getLow_resolution().getHeight();
            String lowResolutionUrl = dtoImages.getLow_resolution().getUrl();

            int standartResolutionWidth = dtoImages.getStandard_resolution().getWidth();
            int standartResolutionHeight = dtoImages.getStandard_resolution().getHeight();
            String standartResolutionUrl = dtoImages.getStandard_resolution().getUrl();

            List<PostImage> postImages = new ArrayList<>();
            postImages.add(new PostImage(THUMBNAIL, thumbnialWidth, thumbnailHeight, thumbnailUrl));
            postImages.add(new PostImage(LOW_RESOLUTION, lowResolutionWidth, lowResolutionHeight, lowResolutionUrl));
            postImages.add(new PostImage(STANDERT_RESOLUTION, standartResolutionWidth, standartResolutionHeight, standartResolutionUrl));

            result.add(new UserPost(currentDataId, postImages));
        }
        return result;
    }
}
