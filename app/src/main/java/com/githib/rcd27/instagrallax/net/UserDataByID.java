package com.githib.rcd27.instagrallax.net;


import com.google.gson.annotations.SerializedName;

public class UserDataByID {

    @SerializedName("data")
    private Data data;
    @SerializedName("meta")
    private Meta meta;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public static class Counts {
        @SerializedName("media")
        private int media;
        @SerializedName("follows")
        private int follows;
        @SerializedName("followedBy")
        private int followedBy;

        public int getMedia() {
            return media;
        }

        public void setMedia(int media) {
            this.media = media;
        }

        public int getFollows() {
            return follows;
        }

        public void setFollows(int follows) {
            this.follows = follows;
        }

        public int getFollowedBy() {
            return followedBy;
        }

        public void setFollowedBy(int followedBy) {
            this.followedBy = followedBy;
        }
    }

    public static class Data {
        @SerializedName("id")
        private String id;
        @SerializedName("username")
        private String username;
        @SerializedName("profilePicture")
        private String profilePicture;
        @SerializedName("fullName")
        private String fullName;
        @SerializedName("bio")
        private String bio;
        @SerializedName("website")
        private String website;
        @SerializedName("isBusiness")
        private boolean isBusiness;
        @SerializedName("counts")
        private Counts counts;

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

        public boolean getBusiness() {
            return isBusiness;
        }

        public void setBusiness(boolean business) {
            this.isBusiness = business;
        }

        public Counts getCounts() {
            return counts;
        }

        public void setCounts(Counts counts) {
            this.counts = counts;
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

