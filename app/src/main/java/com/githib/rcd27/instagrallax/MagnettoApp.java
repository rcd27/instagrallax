package com.githib.rcd27.instagrallax;


import android.app.Application;

import com.githib.rcd27.instagrallax.dagger.AppComponent;
import com.githib.rcd27.instagrallax.dagger.ApplicationModule;
import com.githib.rcd27.instagrallax.dagger.DaggerAppComponent;
import com.githib.rcd27.instagrallax.net.NetworkModule;

public class MagnettoApp extends Application {

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
                .networkModule(new NetworkModule("https://api.instagram.com",
                        "5968608397.efb6703.e766cc20812c4842ab903edded1148c9"))
                .build();
    }
}
