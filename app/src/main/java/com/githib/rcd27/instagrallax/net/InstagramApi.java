package com.githib.rcd27.instagrallax.net;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface InstagramApi {
    /* возвращает HTML форму для ввода login/password с дальнейшим редиректом и получением access_token*/
    @GET("/oauth/authorize/")
    Observable<String> getToken(@Query("client_id") String clientId,
                                @Query("client_secret") String clientSecret,
                                @Query("redirect_url") String redirectUrl,
                                @Query("response_type") String responseType);

    /* Смотрим посты юзера, на которого зарегистрирован access_token*/
    @GET("v1/users/self/media/recent")
    Observable<MediaData> getSelfMediaRecentData(@Query("access_token") String accessToken);

    @GET("v1/users/search")
    Observable<SearchResult> searchUser(@Query("q") String searchQuery,
                                        @Query("access_token") String accessToken);

    @GET("/v1/users/{user-id}/media/recent")
    Observable<UserRecentMedia> getRecentMediaForUser(@Path("user-id") long userId,
                                                      @Query("access_token") String access_token);
}
