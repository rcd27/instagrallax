package com.github.rcd27.instagrallax.net;

import android.content.Context;
import android.support.annotation.NonNull;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    private static final int CACHE_SIZE = 10 * 1024 * 1024;
    private static final String CACHE_CONTROL = "Cache-Control";
    private static final String CACHE_PATH = "httpCache";
    private static final int CONNECT_TIMEOUT = 10;
    private static final String ACCESS_TOKEN = "access_token";

    private final String instagramBaseUrl;
    private final String accessToken;

    public NetworkModule(String instagramBaseUrl, String accessToken) {
        this.instagramBaseUrl = instagramBaseUrl;
        this.accessToken = accessToken;
    }

    @Provides
    @Singleton
    public InstagramApi provideApiInterface(Context context) {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(provideLoggingInterceptor())
//                .addInterceptor(provideOfflineCacheInterceptor())
//                .addNetworkInterceptor(provideCacheInterceptor())
                .addInterceptor(new AccessTokenInterceptor())
                .cache(getCache(context))
                .build();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(instagramBaseUrl)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

        return builder.build()
                .create(InstagramApi.class);
    }

    private Interceptor provideOfflineCacheInterceptor() {
        return chain -> {
            Request request = chain.request();

            CacheControl cacheControl = new CacheControl.Builder()
                    .maxStale(7, TimeUnit.DAYS)
                    .build();

            request = request.newBuilder()
                    .cacheControl(cacheControl)
                    .build();

            return chain.proceed(request);
        };
    }

    private Interceptor provideCacheInterceptor() {
        return chain -> {
            Response response = chain.proceed(chain.request());

            CacheControl cacheControl = new CacheControl.Builder()
                    .maxAge(5, TimeUnit.MINUTES)
                    .build();

            return response.newBuilder()
                    .header(CACHE_CONTROL, cacheControl.toString())
                    .build();
        };
    }

    private HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return interceptor;
    }

    private Cache getCache(Context context) {
        File httpCacheDirectory = new File(context.getCacheDir(), CACHE_PATH);
        return new Cache(httpCacheDirectory, CACHE_SIZE);
    }

    @Provides
    @Singleton
    public Picasso providePicasso(Context context) {
        Picasso picasso = new Picasso.Builder(context)
                .downloader(new OkHttp3Downloader(context, CACHE_SIZE * 2))
                .build();

        picasso.setIndicatorsEnabled(true);
        picasso.setLoggingEnabled(true);

        return picasso;
    }

    private class AccessTokenInterceptor implements Interceptor {
        @Override
        public Response intercept(@NonNull Chain chain) throws IOException {
            Request original = chain.request();
            HttpUrl originalHttpUrl = original.url();

            HttpUrl resultUrl = originalHttpUrl.newBuilder()
                    .addQueryParameter(ACCESS_TOKEN, accessToken)
                    .build();

            Request.Builder requestBuilder = original.newBuilder()
                    .url(resultUrl);

            Request request = requestBuilder.build();
            return chain.proceed(request);
        }
    }
}
