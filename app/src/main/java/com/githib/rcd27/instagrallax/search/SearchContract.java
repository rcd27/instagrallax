package com.githib.rcd27.instagrallax.search;


import android.database.MatrixCursor;
import android.support.annotation.NonNull;

import io.reactivex.Observable;


interface SearchContract {

    interface Model {

        /* Предоставляет список SUGGESTIONS */
        Observable<String[]> getSuggestions(@NonNull String forQuery);

    }

    interface View {

        void showError(@NonNull String errorMessage);

    }

    interface Presenter {

        /* Обновляет список getSuggestions для поиска */
        MatrixCursor refreshSuggestions(@NonNull String query);

    }
}
