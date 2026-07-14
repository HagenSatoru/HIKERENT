package com.Hikerent.dto.request;

import lombok.Data;

@Data
public class OrganizerRequest {

    private Long userId;

    private String namaOrganizer;

    private String alamat;

    private String nomorTelepon;

    private String email;

    private String deskripsi;

}