package com.github.rcd27.instagrallax.net;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResultDTO {

    @SerializedName("data")
    private List<Data> data;
    @SerializedName("meta")
    private Meta meta;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public static class Data {
        @SerializedName("id")
        private long id;
        @SerializedName("username")
        private String username;
        @SerializedName("profile_picture")
        private String profile_picture;
        @SerializedName("full_name")
        private String full_name;
        @SerializedName("bio")
        private String bio;
        @SerializedName("website")
        private String website;
        @SerializedName("is_business")
        private boolean is_business;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getProfile_picture() {
            return profile_picture;
        }

        public void setProfile_picture(String profile_picture) {
            this.profile_picture = profile_picture;
        }

        public String getFull_name() {
            return full_name;
        }

        public void setFull_name(String full_name) {
            this.full_name = full_name;
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

        public boolean getIs_business() {
            return is_business;
        }

        public void setIs_business(boolean is_business) {
            this.is_business = is_business;
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
