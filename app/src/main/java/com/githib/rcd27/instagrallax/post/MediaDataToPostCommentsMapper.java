package com.githib.rcd27.instagrallax.post;


import com.githib.rcd27.instagrallax.net.MediaData;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class MediaDataToPostCommentsMapper implements Function<MediaData, List<PostComment>> {
    @Override
    public List<PostComment> apply(@NonNull MediaData mediaData) throws Exception {
        List<PostComment> result = new ArrayList<>();
        List<MediaData.Data> currentDataList = mediaData.getData();
        for (MediaData.Data currentData : currentDataList) {
            result.add(new PostComment(
                    currentData.getId(),
                    currentData.getText(),
                    currentData.getCreatedTime(),
                    currentData.getFrom().getId(),
                    currentData.getFrom().getUsername(),
                    currentData.getFrom().getFullName(),
                    currentData.getFrom().getProfilePicture())
            );
        }
        return result;
    }
}
