package com.Hikerent.dto.request;

import lombok.Data;

@Data
public class JoinPartnerRequest {

    private Long userId;

    private String tipePartner;

    private String namaUsaha;

    private String alamat;

    private String nomorTelepon;

    private String email;

    private String deskripsi;

}