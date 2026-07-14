package com.Hikerent.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationResponse {

    private Long id;

    private String judul;

    private String pesan;

    private Boolean dibaca;

    private LocalDateTime createdAt;

}