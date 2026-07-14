package com.Hikerent.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JoinPartnerResponse {

    private Long id;

    private String tipePartner;

    private String namaUsaha;

    private String status;

    private LocalDateTime tanggalDaftar;

}