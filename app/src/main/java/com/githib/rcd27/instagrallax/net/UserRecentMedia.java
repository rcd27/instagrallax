package com.githib.rcd27.instagrallax.net;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserRecentMedia {

    @SerializedName("pagination")
    private Pagination pagination;
    @SerializedName("data")
    private List<Data> data;
    @SerializedName("meta")
    private Meta meta;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

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

    public static class Pagination {
    }

    public static class User {
        @SerializedName("id")
        private String id;
        @SerializedName("full_name")
        private String full_name;
        @SerializedName("profile_picture")
        private String profile_picture;
        @SerializedName("username")
        private String username;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFull_name() {
            return full_name;
        }

        public void setFull_name(String full_name) {
            this.full_name = full_name;
        }

        public String getProfile_picture() {
            return profile_picture;
        }

        public void setProfile_picture(String profile_picture) {
            this.profile_picture = profile_picture;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    public static class Thumbnail {
        @SerializedName("width")
        private int width;
        @SerializedName("height")
        private int height;
        @SerializedName("url")
        private String url;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class Low_resolution {
        @SerializedName("width")
        private int width;
        @SerializedName("height")
        private int height;
        @SerializedName("url")
        private String url;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class Standard_resolution {
        @SerializedName("width")
        private int width;
        @SerializedName("height")
        private int height;
        @SerializedName("url")
        private String url;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class Images {
        @SerializedName("thumbnail")
        private Thumbnail thumbnail;
        @SerializedName("low_resolution")
        private Low_resolution low_resolution;
        @SerializedName("standard_resolution")
        private Standard_resolution standard_resolution;

        public Thumbnail getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(Thumbnail thumbnail) {
            this.thumbnail = thumbnail;
        }

        public Low_resolution getLow_resolution() {
            return low_resolution;
        }

        public void setLow_resolution(Low_resolution low_resolution) {
            this.low_resolution = low_resolution;
        }

        public Standard_resolution getStandard_resolution() {
            return standard_resolution;
        }

        public void setStandard_resolution(Standard_resolution standard_resolution) {
            this.standard_resolution = standard_resolution;
        }
    }

    public static class Likes {
        @SerializedName("count")
        private int count;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public static class Comments {
        @SerializedName("count")
        private int count;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public static class Users_in_photo {
    }

    public static class Data {
        @SerializedName("id")
        private String id;
        @SerializedName("user")
        private User user;
        @SerializedName("images")
        private Images images;
        @SerializedName("created_time")
        private String created_time;
        @SerializedName("caption")
        private String caption;
        @SerializedName("user_has_liked")
        private boolean user_has_liked;
        @SerializedName("likes")
        private Likes likes;
        @SerializedName("tags")
        private List<String> tags;
        @SerializedName("filter")
        private String filter;
        @SerializedName("comments")
        private Comments comments;
        @SerializedName("type")
        private String type;
        @SerializedName("link")
        private String link;
        @SerializedName("location")
        private String location;
        @SerializedName("attribution")
        private String attribution;
        @SerializedName("users_in_photo")
        private List<Users_in_photo> users_in_photo;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Images getImages() {
            return images;
        }

        public void setImages(Images images) {
            this.images = images;
        }

        public String getCreated_time() {
            return created_time;
        }

        public void setCreated_time(String created_time) {
            this.created_time = created_time;
        }

        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public boolean getUser_has_liked() {
            return user_has_liked;
        }

        public void setUser_has_liked(boolean user_has_liked) {
            this.user_has_liked = user_has_liked;
        }

        public Likes getLikes() {
            return likes;
        }

        public void setLikes(Likes likes) {
            this.likes = likes;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public String getFilter() {
            return filter;
        }

        public void setFilter(String filter) {
            this.filter = filter;
        }

        public Comments getComments() {
            return comments;
        }

        public void setComments(Comments comments) {
            this.comments = comments;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getAttribution() {
            return attribution;
        }

        public void setAttribution(String attribution) {
            this.attribution = attribution;
        }

        public List<Users_in_photo> getUsers_in_photo() {
            return users_in_photo;
        }

        public void setUsers_in_photo(List<Users_in_photo> users_in_photo) {
            this.users_in_photo = users_in_photo;
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
