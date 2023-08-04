package com.dirt.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dirt.home.model.Community;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {

}
