package com.githib.rcd27.instagrallax.data;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchData {

    @SerializedName("userSearchData")
    private List<UserSearchData> userSearchData;
    @SerializedName("meta")
    private Meta meta;

    public List<UserSearchData> getUserSearchData() {
        return userSearchData;
    }

    public void setUserSearchData(List<UserSearchData> userSearchData) {
        this.userSearchData = userSearchData;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public static class UserSearchData {
        @SerializedName("id")
        private String id;
        @SerializedName("username")
        private String username;
        @SerializedName("profile_picture")
        private String profilePicture;
        @SerializedName("full_name")
        private String fullName;
        @SerializedName("bio")
        private String bio;
        @SerializedName("website")
        private String website;
        @SerializedName("is_business")
        private boolean isBusiness;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getProfilePicture() {
            return profilePicture;
        }

        public void setProfilePicture(String profilePicture) {
            this.profilePicture = profilePicture;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }

        public boolean getIsBusiness() {
            return isBusiness;
        }

        public void setIsBusiness(boolean isBusiness) {
            this.isBusiness = isBusiness;
        }
    }

    public static class Meta {
        @SerializedName("code")
        private int code;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }
}
