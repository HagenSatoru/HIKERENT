package com.Hikerent.service.impl;


import com.Hikerent.dto.response.NotificationResponse;
import com.Hikerent.entity.Notification;
import com.Hikerent.repository.NotificationRepository;
import com.Hikerent.service.NotificationService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class NotificationServiceImpl
        implements NotificationService {



    private final NotificationRepository notificationRepository;



    @Override
    public List<NotificationResponse> getByUser(Long userId) {


        return notificationRepository
                .findByUserId(userId)
                .stream()
                .map(this::mapToResponse)
                .toList();

    }





    @Override
    public void markAsRead(Long id) {


        Notification notification =
                notificationRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Notification tidak ditemukan"
                                )
                        );


        notification.setDibaca(true);


        notificationRepository.save(notification);

    }





    private NotificationResponse mapToResponse(
            Notification notification
    ){


        NotificationResponse response =
                new NotificationResponse();


        response.setId(
                notification.getId()
        );


        response.setJudul(
                notification.getJudul()
        );


        response.setPesan(
                notification.getPesan()
        );


        response.setDibaca(
                notification.getDibaca()
        );


        return response;

    }


}