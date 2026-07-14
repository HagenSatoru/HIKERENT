package com.Hikerent.service;

import com.Hikerent.dto.request.FinancialReportRequest;
import com.Hikerent.dto.response.FinancialReportResponse;

import java.util.List;

public interface FinancialReportService {

    FinancialReportResponse create(FinancialReportRequest request);

    FinancialReportResponse getById(Long id);

    List<FinancialReportResponse> getAll();

    List<FinancialReportResponse> getBySeller(Long sellerId);

    List<FinancialReportResponse> getByOrganizer(Long organizerId);

}