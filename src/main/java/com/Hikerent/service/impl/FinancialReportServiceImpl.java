package com.Hikerent.service.impl;


import com.Hikerent.dto.response.FinancialReportResponse;
import com.Hikerent.entity.FinancialReport;
import com.Hikerent.repository.FinancialReportRepository;
import com.Hikerent.service.FinancialReportService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class FinancialReportServiceImpl
        implements FinancialReportService {



    private final FinancialReportRepository financialReportRepository;




    @Override
    public List<FinancialReportResponse> getAll() {


        return financialReportRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();

    }





    @Override
    public FinancialReportResponse getById(Long id) {


        FinancialReport report =
                financialReportRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Laporan tidak ditemukan"
                                )
                        );


        return mapToResponse(report);

    }





    private FinancialReportResponse mapToResponse(
            FinancialReport report
    ){

        FinancialReportResponse response =
                new FinancialReportResponse();


        response.setId(
                report.getId()
        );


        response.setBulan(
                report.getBulan()
        );


        response.setTahun(
                report.getTahun()
        );


        response.setTotalPendapatan(
                report.getTotalPendapatan()
        );


        response.setTotalTransaksi(
                report.getTotalTransaksi()
        );


        return response;

    }

}