package com.dirt.home.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dirt.home.model.Star;

@Repository
public interface StarRepository extends JpaRepository<Star, Long> {
    List<Star> findAllByUserUserID(Long userID); // Fix the method name and parameter
}
