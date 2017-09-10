package com.githib.rcd27.instagrallax.search;


import com.githib.rcd27.instagrallax.net.SearchResultDTO;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class SearchUserMapper
        implements Function<SearchResultDTO, List<SearchUser>> {

    @Override
    public List<SearchUser> apply(@NonNull SearchResultDTO searchResultDTO) throws Exception {
        List<SearchUser> result = new ArrayList<>();
        for (SearchResultDTO.Data currentData : searchResultDTO.getData()) {
            result.add(new SearchUser(currentData.getId(),
                    currentData.getFull_name(),
                    currentData.getUsername(),
                    currentData.getProfile_picture()));
        }
        return result;
    }
}
