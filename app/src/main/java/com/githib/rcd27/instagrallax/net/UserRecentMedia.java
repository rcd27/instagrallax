package com.githib.rcd27.instagrallax.net;


import com.google.gson.annotations.SerializedName;

import java.util.List;

//TODO проанализировать все DTO и вывести общие части, вынести их.

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
        @SerializedName("fullName")
        private String fullName;
        @SerializedName("profilePicture")
        private String profilePicture;
        @SerializedName("username")
        private String username;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getProfilePicture() {
            return profilePicture;
        }

        public void setProfilePicture(String profilePicture) {
            this.profilePicture = profilePicture;
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

    public static class LowResolution {
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

    public static class StandarResolution {
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
        @SerializedName("lowResolution")
        private LowResolution lowResolution;
        @SerializedName("standardResolution")
        private StandarResolution standardResolution;

        public Thumbnail getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(Thumbnail thumbnail) {
            this.thumbnail = thumbnail;
        }

        public LowResolution getLowResolution() {
            return lowResolution;
        }

        public void setLowResolution(LowResolution lowResolution) {
            this.lowResolution = lowResolution;
        }

        public StandarResolution getStandardResolution() {
            return standardResolution;
        }

        public void setStandardResolution(StandarResolution standardResolution) {
            this.standardResolution = standardResolution;
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
        @SerializedName("createdTime")
        private String createdTime;
        @SerializedName("caption")
        private String caption;
        @SerializedName("userHasLiked")
        private boolean userHasLiked;
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
        @SerializedName("usersInPhotos")
        private List<Users_in_photo> usersInPhotos;

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

        public String getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(String createdTime) {
            this.createdTime = createdTime;
        }

        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public boolean getUserHasLiked() {
            return userHasLiked;
        }

        public void setUserHasLiked(boolean userHasLiked) {
            this.userHasLiked = userHasLiked;
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

        public List<Users_in_photo> getUsersInPhotos() {
            return usersInPhotos;
        }

        public void setUsersInPhotos(List<Users_in_photo> usersInPhotos) {
            this.usersInPhotos = usersInPhotos;
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
