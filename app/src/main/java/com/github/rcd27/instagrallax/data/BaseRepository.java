package com.github.rcd27.instagrallax.data;


import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

class BaseRepository {

    final ObservableTransformer schedulersTransformer;

    BaseRepository() {
        this.schedulersTransformer = observable -> observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
