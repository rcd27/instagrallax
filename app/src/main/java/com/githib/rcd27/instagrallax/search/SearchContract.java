package com.githib.rcd27.instagrallax.search;


import android.database.MatrixCursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import io.reactivex.Observable;


interface SearchContract {

    interface Model {

        /* Предоставляет список SUGGESTIONS */
        Observable<String[]> getSuggestions(@NonNull String forQuery);

        Observable<String[]> getAllSuggetsions();
    }

    interface View {

        void showError(@NonNull String errorMessage);

        void showUser(@NonNull String query);

    }

    interface Presenter {

        /* Обновляет список getSuggestions для поиска */
        MatrixCursor refreshSuggestions(@NonNull String query);

        void goToUserIfExists(@Nullable String query);
    }
}
