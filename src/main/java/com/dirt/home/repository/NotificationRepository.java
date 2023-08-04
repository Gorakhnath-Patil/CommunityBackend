package com.dirt.home.repository;

import com.dirt.home.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    // Add custom query methods here if needed
}
