package com.Hikerent.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetailResponse {

    private Long id;

    private Integer jumlah;

    private BigDecimal harga;

    private BigDecimal subtotal;

    private String namaProduk;

    private String namaTrip;

}