package com.dirt.home.repository;

import com.dirt.home.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // You can add custom query methods here if needed
}
