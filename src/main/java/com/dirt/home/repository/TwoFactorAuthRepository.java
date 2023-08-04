package com.dirt.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dirt.home.model.TwoFactorAuth;

@Repository
public interface TwoFactorAuthRepository extends JpaRepository<TwoFactorAuth, Long> {
    // Custom queries or methods if required
}
