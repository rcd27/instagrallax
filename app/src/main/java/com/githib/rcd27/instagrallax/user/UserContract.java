package com.githib.rcd27.instagrallax.user;


import android.support.annotation.NonNull;

public interface UserContract {

    interface View{

        void showError();

        void setTitleForCurrentUser(@NonNull String userName);
    }

    interface Presenter{

        void getUserNameById(int currentUserId);
    }
}
