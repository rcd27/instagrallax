package com.githib.rcd27.instagrallax;


import com.githib.rcd27.instagrallax.net.InstagramApi;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static junit.framework.Assert.assertEquals;

public class SearchTest {
    InstagramApi api;

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
    public void searchTest() {
        api.searchUser("Станислав Земляков", "5968608397.efb6703.e766cc20812c4842ab903edded1148c9")
                .subscribe(userData -> assertEquals(
                        "Станислав Земляков", userData.getData().get(0).getFull_name()));
    }
}

