package com.dirt.home.service;

import com.dirt.home.model.Notification;

import java.util.List;

public interface NotificationService {
    List<Notification> getAllNotifications();

    Notification getNotificationById(Long id);

    Notification createNotification(Notification notification);

    Notification updateNotification(Long id, Notification updatedNotification);

    void deleteNotification(Long id);
}
