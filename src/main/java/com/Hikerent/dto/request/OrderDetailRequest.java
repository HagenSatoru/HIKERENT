package com.Hikerent.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetailRequest {

    private Long productId;

    private Long openTripId;

    private Integer jumlah;

    private BigDecimal harga;

}