package com.Hikerent.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FinancialReportRequest {

    private Integer bulan;

    private Integer tahun;

    private BigDecimal totalPendapatan;

    private BigDecimal totalTransaksi;

    private Long sellerId;

    private Long organizerId;

}