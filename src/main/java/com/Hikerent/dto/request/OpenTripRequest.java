package com.Hikerent.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OpenTripRequest {

    private String namaTrip;

    private String deskripsi;

    private BigDecimal harga;

    private Integer kuota;

    private LocalDate tanggalBerangkat;

    private LocalDate tanggalPulang;

    private String meetingPoint;

    private String gambar;

    private Long organizerId;

    private Long mountainId;

}