package com.Hikerent.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NewsResponse {

    private Long id;

    private String judul;

    private String isi;

    private String gambar;

    private String sumber;

    private LocalDateTime createdAt;

}