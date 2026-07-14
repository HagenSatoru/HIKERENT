package com.Hikerent.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentResponse {

    private Long id;

    private BigDecimal nominal;

    private String buktiTransfer;

    private String metodePembayaran;

    private String status;

    private LocalDateTime tanggalPembayaran;

}