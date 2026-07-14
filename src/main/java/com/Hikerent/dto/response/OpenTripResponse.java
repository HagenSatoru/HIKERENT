package com.Hikerent.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OpenTripResponse {

    private Long id;

    private String namaTrip;

    private String deskripsi;

    private BigDecimal harga;

    private Integer kuota;

    private LocalDate tanggalBerangkat;

    private LocalDate tanggalPulang;

    private String meetingPoint;

    private String gambar;

    private String namaOrganizer;

    private String namaGunung;

}