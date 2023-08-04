package com.dirt.home.repository;

import com.dirt.home.model.SingleSignOn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingleSignOnRepository extends JpaRepository<SingleSignOn, Long> {
    // You can add custom query methods here if needed
}
