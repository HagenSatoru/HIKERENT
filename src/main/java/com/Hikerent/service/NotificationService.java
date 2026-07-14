package com.Hikerent.service;

import com.Hikerent.dto.response.NotificationResponse;

import java.util.List;

public interface NotificationService {


    List<NotificationResponse> getByUser(Long userId);


    void readNotification(Long id);


    void delete(Long id);

}