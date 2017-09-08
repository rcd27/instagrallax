package com.githib.rcd27.instagrallax.user;


public class PostImage {
    public final String category;
    public final int width;
    public final int height;
    public final String url;

    public PostImage(String category, int width, int height, String url) {
        this.category = category;
        this.width = width;
        this.height = height;
        this.url = url;
    }
}
