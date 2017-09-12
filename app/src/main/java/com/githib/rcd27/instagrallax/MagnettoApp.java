package com.githib.rcd27.instagrallax;


import android.app.Application;

import com.githib.rcd27.instagrallax.dagger.AppComponent;
import com.githib.rcd27.instagrallax.dagger.ApplicationModule;
import com.githib.rcd27.instagrallax.dagger.DaggerAppComponent;
import com.githib.rcd27.instagrallax.net.NetworkModule;

/**
 * TODO:
 * 1) BasePresenter(cd:CompositeDisposable) <- all presenters implement add(), onDetach()
 * 2) BaseRepository(st:SchedulerTranformer) <- all repos
 * 3) PostImage: method refactor -> sort(String quality){...}
 * 4) On image click: transfer @ResId instead of ImageView to the presenter
 */
public class MagnettoApp extends Application {
    public static final String BASE_URL = "https://api.instagram.com";
    public static final String ACCESS_TOKEN = "5968608397.efb6703.e766cc20812c4842ab903edded1148c9";

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
                .networkModule(new NetworkModule(BASE_URL, ACCESS_TOKEN))
                .build();
    }
}
