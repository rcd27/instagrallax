package com.github.rcd27.instagrallax;


import android.app.Application;

import com.github.rcd27.instagrallax.dagger.AppComponent;
import com.github.rcd27.instagrallax.dagger.ApplicationModule;
import com.github.rcd27.instagrallax.dagger.DaggerAppComponent;
import com.github.rcd27.instagrallax.net.NetworkModule;

/**
 * TODO:
 * 1) BasePresenter(cd:CompositeDisposable) <- all presenters implement add(), onDetach()
 *  → → 2) BaseRepository(st:SchedulerTransformer) <- all repos
 * 3) PostImage: method refactor -> sort(String quality){...}
 * 4) On image click: transfer @ResId instead of ImageView to the presenter
 */
public class MagnettoApp extends Application {
    public static final String BASE_URL = "https://api.instagram.com";

    private static MagnettoApp instance;

    public static MagnettoApp getInstance() {
        return instance;
    }

    protected AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initDagger();
    }

    private void initDagger() {
        appComponent = DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule(BASE_URL, BuildConfig.INSTAGRAM_ACCESS_TOKEN))
                .build();
    }
}
