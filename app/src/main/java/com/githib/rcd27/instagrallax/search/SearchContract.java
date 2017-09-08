package com.githib.rcd27.instagrallax.search;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.githib.rcd27.instagrallax.user.UserPost;

import java.util.List;

import io.reactivex.Observable;


public interface SearchContract {

    interface View {

        void showError(@NonNull String errorMessage);

        void showUser(long userId);

        void showSuggestions(List<SearchUser> users);

    }

    interface Presenter {

        void goToUserIfExists(@Nullable String query);

        void procedeUserSearch(@NonNull String query);
    }
}
