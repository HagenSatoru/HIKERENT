package com.Hikerent.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FinancialReportResponse {

    private Long id;

    private Integer bulan;

    private Integer tahun;

    private BigDecimal totalPendapatan;

    private BigDecimal totalTransaksi;

    private String namaPartner;

}