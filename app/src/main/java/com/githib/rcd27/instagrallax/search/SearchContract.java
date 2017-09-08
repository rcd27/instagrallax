package com.githib.rcd27.instagrallax.search;


import android.database.MatrixCursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;

import java.util.List;

import io.reactivex.Observable;


public interface SearchContract {

    interface Model {

        Observable<String> getUserById(int id);

        Observable<List<SearchUser>> getSearchUserList(@NonNull String forQuery);

    }

    interface View {

        void showError(@NonNull String errorMessage);

        void showUser(int userId);

        void showSuggestions(List<SearchUser> users);

    }

    interface Presenter {

        void goToUserIfExists(@Nullable String query);

        void procedeUserSearch(@NonNull String query);
    }
}
