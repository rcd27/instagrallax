package com.githib.rcd27.instagrallax.net;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface InstagramApi {

    @GET("v1/users/search")
    Observable<SearchResultDTO> searchUser(@Query("q") String searchQuery);

    @GET("/v1/users/{user-id}/media/recent")
    Observable<UserRecentMediaDTO> getRecentMediaForUser(@Path("user-id") long userId);

    @GET("v1/users/{user-id}/")
    Observable<UserDataByIdDTO> getUserDataById(@Path("user-id") long userId);

    @GET("v1/media/{media-id}/comments/")
    Observable<List<MediaDataDTO>> getCommentsForPost(@Path("media-id") String postId);
}
