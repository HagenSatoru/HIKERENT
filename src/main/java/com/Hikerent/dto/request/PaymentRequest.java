package com.Hikerent.dto.request;

import lombok.Data;

import com.Hikerent.enums.PaymentMethod;

import java.math.BigDecimal;

@Data
public class PaymentRequest {

    private Long orderId;

    private BigDecimal nominal;

    private String buktiTransfer;

    private PaymentMethod metodePembayaran;

}