package com.dirt.home.service;

import com.dirt.home.exceptions.EntityNotFoundException;
import com.dirt.home.model.Notification;
import com.dirt.home.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Notification not found with id: " + id));
    }

    @Override
    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification updateNotification(Long id, Notification updatedNotification) {
        Notification existingNotification = getNotificationById(id);
        existingNotification.setTitle(updatedNotification.getTitle());
        existingNotification.setMessage(updatedNotification.getMessage());
        // Set other properties if applicable
        return notificationRepository.save(existingNotification);
    }

    @Override
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}
