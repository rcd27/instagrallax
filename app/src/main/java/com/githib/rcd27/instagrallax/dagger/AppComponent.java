package com.githib.rcd27.instagrallax.dagger;


import com.githib.rcd27.instagrallax.net.NetworkModule;

import dagger.Component;

@Component(modules = {ApplicationModule.class, NetworkModule.class, DataModule.class})
public interface AppComponent {

    SearchComponent plus(SearchModule searchModule);

    UserComponent plus(UserModule userModule);

    PostComponent plus(PostModule postModule);

}
