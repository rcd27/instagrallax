package com.githib.rcd27.instagrallax.search;

import android.support.annotation.NonNull;

import com.githib.rcd27.instagrallax.VisualObject;

@VisualObject
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

    public String getFullName() {
        return fullName;
    }

    public String getLogin() {
        return login;
    }

    public String getUserProfilePicture() {
        return userProfilePicture;
    }
}
