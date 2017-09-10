package com.githib.rcd27.instagrallax;


import com.githib.rcd27.instagrallax.net.InstagramApi;
import com.githib.rcd27.instagrallax.net.UserRecentMediaDTO;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class ApiTest {
    private static final String SELF_FULL_NAME = "Станислав Земляков";

    private InstagramApi api;
    private final long[] idContainer = new long[1];

    @Before
    public void prepareApi() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(provideLoggingInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.instagram.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();

        api = retrofit.create(InstagramApi.class);
    }

    private Interceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return interceptor;
    }

    @Test
    public void search_test() {
        api.searchUser("Ста")
                .subscribe(userData ->
                        assertEquals(SELF_FULL_NAME, userData.getData().get(0).getFull_name()));
    }

    @Test
    public void id_test() {
        api.searchUser(SELF_FULL_NAME)
                .subscribe(userData -> idContainer[0] = userData.getData().get(0).getId());
        Assert.assertNotNull(idContainer[0]);
    }

    @Test
    public void recent_media_test() {
        api.getRecentMediaForUser(5968608397L)
                .subscribe(userRecentMediaDTO -> {
                    List<UserRecentMediaDTO.Data> userRecentMediaData = userRecentMediaDTO.getData();
                    assertNotNull(userRecentMediaData);
                    System.out.println(userRecentMediaData.get(0).getId());
                });
    }
}

