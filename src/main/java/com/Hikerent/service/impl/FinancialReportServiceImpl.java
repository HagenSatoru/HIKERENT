package com.Hikerent.service.impl;

import com.Hikerent.dto.request.FinancialReportRequest;
import com.Hikerent.dto.response.FinancialReportResponse;
import com.Hikerent.entity.FinancialReport;
import com.Hikerent.entity.Organizer;
import com.Hikerent.entity.Seller;
import com.Hikerent.repository.FinancialReportRepository;
import com.Hikerent.repository.OrganizerRepository;
import com.Hikerent.repository.SellerRepository;
import com.Hikerent.service.FinancialReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FinancialReportServiceImpl implements FinancialReportService {

    private final FinancialReportRepository financialReportRepository;
    private final SellerRepository sellerRepository;
    private final OrganizerRepository organizerRepository;

    @Override
    public FinancialReportResponse create(FinancialReportRequest request) {

        Seller seller = null;
        Organizer organizer = null;

        if (request.getSellerId() != null) {
            seller = sellerRepository.findById(request.getSellerId())
                    .orElseThrow(() ->
                            new RuntimeException("Seller tidak ditemukan"));
        }

        if (request.getOrganizerId() != null) {
            organizer = organizerRepository.findById(request.getOrganizerId())
                    .orElseThrow(() ->
                            new RuntimeException("Organizer tidak ditemukan"));
        }

        FinancialReport report = FinancialReport.builder()
                .bulan(request.getBulan())
                .tahun(request.getTahun())
                .totalPendapatan(request.getTotalPendapatan())
                .totalTransaksi(request.getTotalTransaksi())
                .seller(seller)
                .organizer(organizer)
                .build();

        return mapToResponse(financialReportRepository.save(report));
    }

    @Override
    public FinancialReportResponse getById(Long id) {

        FinancialReport report = financialReportRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Laporan tidak ditemukan"));

        return mapToResponse(report);
    }

    @Override
    public List<FinancialReportResponse> getAll() {

        return financialReportRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<FinancialReportResponse> getBySeller(Long sellerId) {

        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() ->
                        new RuntimeException("Seller tidak ditemukan"));

        return financialReportRepository.findBySeller(seller)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<FinancialReportResponse> getByOrganizer(Long organizerId) {

        Organizer organizer = organizerRepository.findById(organizerId)
                .orElseThrow(() ->
                        new RuntimeException("Organizer tidak ditemukan"));

        return financialReportRepository.findByOrganizer(organizer)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private FinancialReportResponse mapToResponse(FinancialReport report) {

        FinancialReportResponse response = new FinancialReportResponse();

        response.setId(report.getId());
        response.setBulan(report.getBulan());
        response.setTahun(report.getTahun());
        response.setTotalPendapatan(report.getTotalPendapatan());
        response.setTotalTransaksi(report.getTotalTransaksi());

        if (report.getSeller() != null) {
            response.setSellerId(report.getSeller().getId());
        }

        if (report.getOrganizer() != null) {
            response.setOrganizerId(report.getOrganizer().getId());
        }

        return response;
    }
}