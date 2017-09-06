package com.githib.rcd27.instagrallax.dagger;


import com.githib.rcd27.instagrallax.net.NetworkModule;


import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface AppComponent {

    SearchComponent plus(SearchModule searchModule);

}
