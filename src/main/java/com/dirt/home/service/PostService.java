package com.dirt.home.service;

import com.dirt.home.model.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();

    Post getPostById(Long id);

    Post createPost(Post post);

    Post updatePost(Long id, Post updatedPost);

    void deletePost(Long id);
}
