package com.github.rcd27.instagrallax.search;

import android.support.annotation.NonNull;

public class SearchUser {
    private final long id;
    private final String fullName;
    private final String login;
    private final String userProfilePicture;

    public SearchUser(long id,
                      @NonNull String fullName,
                      @NonNull String login,
                      @NonNull String userProfilePicture) {
        this.id = id;
        this.fullName = fullName;
        this.login = login;
        this.userProfilePicture = userProfilePicture;
    }

    public long getId() {
        return id;
    }

    @NonNull
    public String getFullName() {
        return fullName;
    }

    @NonNull
    public String getLogin() {
        return login;
    }

    @NonNull
    public String getUserProfilePicture() {
        return userProfilePicture;
    }
}
