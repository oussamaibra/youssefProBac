package com.example.Task_Management.services;

import com.example.Task_Management.dto.CountType;
import com.example.Task_Management.entities.Notification;
import com.example.Task_Management.repositories.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NotificationService {

    private NotificationRepository notificationRepository;

    public List<Notification> getNotifications()
    {
        return notificationRepository.getAllNotification();
    }

    public List<Notification> getNotificationsByUserId(Long user_id)
    {
        return notificationRepository.getAllNotificationByUserId(user_id);
    }

    public Optional<Notification> getNotificationsById(Long id)
    {
        return notificationRepository.findById(id);
    }

    public Notification save(Notification task)
    {
        return notificationRepository.saveAndFlush(task);
    }

    public boolean existsById(Long id)
    {
        return notificationRepository.existsById(id);
    }


}
