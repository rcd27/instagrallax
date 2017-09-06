package com.githib.rcd27.instagrallax;


import com.githib.rcd27.instagrallax.net.InstagramApi;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static junit.framework.Assert.assertNotNull;

public class SelfTest {
    InstagramApi instagramApi;

    @Before
    public void prepareRetrofit() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder.baseUrl("https://api.instagram.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        instagramApi = retrofit.create(InstagramApi.class);
    }

    @Test
    public void selfMediaTest() {
        instagramApi.getSelfMediaRecentData("5968608397.efb6703.e766cc20812c4842ab903edded1148c9")
                .subscribe(response -> {
                    assertNotNull(response.data.get(0).id);
                });
    }
}
