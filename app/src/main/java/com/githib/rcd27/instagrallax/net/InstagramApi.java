package com.githib.rcd27.instagrallax.net;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface InstagramApi {

    @GET("v1/users/search")
    Observable<SearchResult> searchUser(@Query("q") String searchQuery);

    @GET("/v1/users/{user-id}/media/recent")
    Observable<UserRecentMedia> getRecentMediaForUser(@Path("user-id") long userId);

    @GET("v1/users/{user-id}/")
    Observable<UserDataByID> getUserDataById(@Path("user-id") long userId);
}
