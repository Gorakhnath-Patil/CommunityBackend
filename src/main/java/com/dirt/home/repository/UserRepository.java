package com.dirt.home.repository;

import com.dirt.home.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Add any custom query methods if required
}
