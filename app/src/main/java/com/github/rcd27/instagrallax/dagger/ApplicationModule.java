package com.github.rcd27.instagrallax.dagger;


import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Context context;

    // FIXME: то есть для всего приложения подготавливается ApplicationContext? Если да, то пофиксить на использование конкретного
    // контекста для конкретных нужд.
    public ApplicationModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideContext() {
        return context;
    }
}
