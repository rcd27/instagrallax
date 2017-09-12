package com.github.rcd27.instagrallax.user;


public class PostImage {
    final String category;
    final int width;
    final int height;
    final String url;

    public PostImage(String category, int width, int height, String url) {
        this.category = category;
        this.width = width;
        this.height = height;
        this.url = url;
    }
}
