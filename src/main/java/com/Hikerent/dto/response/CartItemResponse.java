package com.Hikerent.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemResponse {

    private Long id;

    private Integer jumlah;

    private String namaProduk;

    private String namaTrip;

    private BigDecimal harga;

}