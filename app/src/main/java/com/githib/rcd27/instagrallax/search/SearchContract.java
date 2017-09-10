package com.githib.rcd27.instagrallax.search;


import android.support.annotation.NonNull;

import java.util.List;


public interface SearchContract {

    interface View {

        void showError(@NonNull String errorMessage);

        void showUser(long userId);

        void showSuggestions(List<SearchUser> users);

    }

    interface Presenter {

        void proceedUserSearch(@NonNull String query);

    }
}
