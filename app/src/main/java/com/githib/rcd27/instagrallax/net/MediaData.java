package com.githib.rcd27.instagrallax.net;


import com.google.gson.annotations.SerializedName;

import java.util.List;

//TODO сравнить MediaData, SearchResult, UserRecentMedia, выявить общие DTO.
public class MediaData {

    @SerializedName("pagination")
    public Pagination pagination;
    @SerializedName("data")
    public List<Data> data;
    @SerializedName("meta")
    public Meta meta;

    private static class Pagination {
    }

    private static class User {
        @SerializedName("id")
        public String id;
        @SerializedName("full_name")
        public String full_name;
        @SerializedName("profile_picture")
        public String profile_picture;
        @SerializedName("username")
        public String username;
    }

    private static class Thumbnail {
        @SerializedName("width")
        public int width;
        @SerializedName("height")
        public int height;
        @SerializedName("url")
        public String url;
    }

    private static class Low_resolution {
        @SerializedName("width")
        public int width;
        @SerializedName("height")
        public int height;
        @SerializedName("url")
        public String url;
    }

    private static class Standard_resolution {
        @SerializedName("width")
        public int width;
        @SerializedName("height")
        public int height;
        @SerializedName("url")
        public String url;
    }

    private static class Images {
        @SerializedName("thumbnail")
        public Thumbnail thumbnail;
        @SerializedName("low_resolution")
        public Low_resolution low_resolution;
        @SerializedName("standard_resolution")
        public Standard_resolution standard_resolution;
    }

    private static class Likes {
        @SerializedName("count")
        public int count;
    }

    private static class Comments {
        @SerializedName("count")
        public int count;
    }

    private static class Users_in_photo {
    }

    public static class Data {
        @SerializedName("id")
        public String id;
        @SerializedName("user")
        public User user;
        @SerializedName("images")
        public Images images;
        @SerializedName("created_time")
        public String created_time;
        @SerializedName("caption")
        public String caption;
        @SerializedName("user_has_liked")
        public boolean user_has_liked;
        @SerializedName("likes")
        public Likes likes;
        @SerializedName("tags")
        public List<String> tags;
        @SerializedName("filter")
        public String filter;
        @SerializedName("comments")
        public Comments comments;
        @SerializedName("type")
        public String type;
        @SerializedName("link")
        public String link;
        @SerializedName("location")
        public String location;
        @SerializedName("attribution")
        public String attribution;
        @SerializedName("users_in_photo")
        public List<Users_in_photo> users_in_photo;
    }

    public static class Meta {
        @SerializedName("code")
        public int code;
    }
}
