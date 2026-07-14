package com.Hikerent.service.impl;

import com.Hikerent.dto.response.NotificationResponse;
import com.Hikerent.entity.Notification;
import com.Hikerent.entity.User;
import com.Hikerent.repository.NotificationRepository;
import com.Hikerent.repository.UserRepository;
import com.Hikerent.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    @Override
    public List<NotificationResponse> getByUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User tidak ditemukan"));

        return notificationRepository.findByUser(user)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public void readNotification(Long id) {

        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Notification tidak ditemukan"));

        notification.setDibaca(true);

        notificationRepository.save(notification);
    }

    @Override
    public void delete(Long id) {

        notificationRepository.deleteById(id);
    }

    private NotificationResponse mapToResponse(Notification notification) {

        NotificationResponse response = new NotificationResponse();

        response.setId(notification.getId());
        response.setJudul(notification.getJudul());
        response.setPesan(notification.getPesan());
        response.setDibaca(notification.getDibaca());

        return response;
    }
}