package com.githib.rcd27.instagrallax.search;


import com.githib.rcd27.instagrallax.net.SearchResult;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class SearchUserMapper
        implements Function<SearchResult, List<SearchUser>> {

    @Override
    public List<SearchUser> apply(@NonNull SearchResult searchResult) throws Exception {
        List<SearchUser> result = new ArrayList<>();
        for (SearchResult.Data currentData : searchResult.getData()) {
            result.add(new SearchUser(currentData.getId(),
                    currentData.getFull_name(),
                    currentData.getUsername(),
                    currentData.getProfile_picture()));
        }
        return result;
    }
}
