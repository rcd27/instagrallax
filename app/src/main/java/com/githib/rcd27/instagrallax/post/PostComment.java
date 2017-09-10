package com.githib.rcd27.instagrallax.post;

import com.githib.rcd27.instagrallax.VisualObject;

@VisualObject
public class PostComment {
    public final String commentId;
    public final String commentText;
    // TODO понять, как оно формируется
    public final String createdTime;

    public final String fromUserId;
    public final String fromUserUsername;
    public final String fromUserFullName;
    public final String fromUserProfilePictureUrl;

    PostComment(String commentId,
                String commentText,
                String createdTime,
                String fromUserId,
                String fromUserUsername,
                String fromUserFullName,
                String fromUserProfilePictureUrl) {
        this.commentId = commentId;
        this.commentText = commentText;
        this.createdTime = createdTime;
        this.fromUserId = fromUserId;
        this.fromUserUsername = fromUserUsername;
        this.fromUserFullName = fromUserFullName;
        this.fromUserProfilePictureUrl = fromUserProfilePictureUrl;
    }
}
