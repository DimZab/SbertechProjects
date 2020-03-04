package ru.sbertech.javaschoolrnd.d1zab.SocialNetwork.Posts.src.main.java.socialnetwork.posts;

import java.util.List;

public interface IPostsStorage {
    List<Post> getPosts(long userid);
    void putPost(Post post);
}