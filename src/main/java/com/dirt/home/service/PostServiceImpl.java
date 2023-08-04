package com.dirt.home.service;

import com.dirt.home.exceptions.EntityNotFoundException;
import com.dirt.home.model.Post;
import com.dirt.home.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post not found with id: " + id));
    }

    @Override
    public Post createPost(Post post) {
        post.setCreatedAt(LocalDateTime.now());
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Long id, Post updatedPost) {
        Post existingPost = getPostById(id);
        existingPost.setUser(updatedPost.getUser());
        existingPost.setContent(updatedPost.getContent());
        // Set other properties if applicable
        return postRepository.save(existingPost);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
