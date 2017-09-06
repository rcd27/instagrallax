package com.githib.rcd27.instagrallax;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.githib.rcd27.instagrallax.net.InstagramApi;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class InstagramApiTokenTest {
    InstagramApi instagramApi;

    @Before
    public void prepareRetrofit() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor())
                .build();

        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder.baseUrl("https://instagramApi.instagram.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(new Converter.Factory() {
                    @Nullable
                    @Override
                    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
                        return new Converter<ResponseBody, String>() {
                            @Override
                            public String convert(@NonNull ResponseBody value) throws IOException {
                                return value.string();
                            }
                        };
                    }
                })
                .client(client)
                .build();
        instagramApi = retrofit.create(InstagramApi.class);
    }

    /**
     * Просто смотрим, что нам возвращает API : String
     */
    @Test
    public void testWhatWeHave() {
        instagramApi.getToken("efb6703a97aa428883a860f87f5f66e7",
                "7b3d9f073b7f48b9808cb8751ea98361",
                "http://github.com/rcd27",
                "token")
                .subscribe(System.out::println);
    }
}
