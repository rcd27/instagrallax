package com.githib.rcd27.instagrallax.post;


import com.githib.rcd27.instagrallax.net.MediaDataDTO;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class MediaDataToPostCommentsMapper implements Function<MediaDataDTO, List<PostComment>> {
    @Override
    public List<PostComment> apply(@NonNull MediaDataDTO mediaDataDTO) throws Exception {
        List<PostComment> result = new ArrayList<>();
        List<MediaDataDTO.Data> currentDataList = mediaDataDTO.getData();
        for (MediaDataDTO.Data currentData : currentDataList) {
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
