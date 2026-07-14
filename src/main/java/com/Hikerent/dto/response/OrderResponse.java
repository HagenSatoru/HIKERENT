package com.Hikerent.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponse {

    private Long id;

    private String nomorOrder;

    private BigDecimal totalHarga;

    private String status;

    private LocalDateTime tanggalOrder;

    private List<OrderDetailResponse> detail;

}