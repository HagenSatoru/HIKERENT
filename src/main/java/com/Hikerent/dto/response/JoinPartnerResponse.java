package com.Hikerent.dto.response;

import com.Hikerent.enums.JoinPartnerStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JoinPartnerResponse {

    private Long id;
    private Long userId;
    private String tipePartner;
    private String namaUsaha;
    private JoinPartnerStatus status;
    private LocalDateTime tanggalDaftar;

    // TAMBAHKAN / PASTIKAN ATRIBUT INI ADA:
    private String alamat;
    private String nomorTelepon;
    private String email;
    private String deskripsi;

    // JANGAN ADA method set...() manual di sini,
    // karena anotasi @Data dari Lombok sudah membuatkannya secara otomatis!
}