package com.Hikerent.dto.response;

import com.Hikerent.enums.JoinPartnerStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JoinPartnerResponse {

    private Long id;

    private String tipePartner;

    private String namaUsaha;

    private String status;

    private LocalDateTime tanggalDaftar;

    public void setUserId(Long id) {
    }

    public void setAlamat(String alamat) {
    }

    public void setNomorTelepon(String nomorWhatsapp) {
    }

    public void setEmail(String emailUsaha) {
    }

    public void setDeskripsi(String deskripsi) {
    }

    public void setStatus(JoinPartnerStatus status) {
    }
}