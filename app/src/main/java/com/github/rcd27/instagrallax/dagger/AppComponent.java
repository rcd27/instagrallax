package com.github.rcd27.instagrallax.dagger;


import com.github.rcd27.instagrallax.net.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class, DataModule.class})
public interface AppComponent {

    SearchComponent plus(SearchModule searchModule);

    UserComponent plus(UserModule userModule);

    PostComponent plus(PostModule postModule);

}
