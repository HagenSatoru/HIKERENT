package com.Hikerent.controller;

import com.Hikerent.dto.request.FinancialReportRequest;
import com.Hikerent.dto.response.FinancialReportResponse;
import com.Hikerent.service.FinancialReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/financial-reports")
@RequiredArgsConstructor
public class FinancialReportController {

    private final FinancialReportService financialReportService;

    @PostMapping
    public ResponseEntity<FinancialReportResponse> create(
            @RequestBody FinancialReportRequest request){

        return ResponseEntity.ok(
                financialReportService.create(request)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinancialReportResponse> getById(
            @PathVariable Long id){

        return ResponseEntity.ok(
                financialReportService.getById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<FinancialReportResponse>> getAll(){

        return ResponseEntity.ok(
                financialReportService.getAll()
        );
    }

    @GetMapping("/seller/{sellerId}")
    public ResponseEntity<List<FinancialReportResponse>> getBySeller(
            @PathVariable Long sellerId){

        return ResponseEntity.ok(
                financialReportService.getBySeller(sellerId)
        );
    }

    @GetMapping("/organizer/{organizerId}")
    public ResponseEntity<List<FinancialReportResponse>> getByOrganizer(
            @PathVariable Long organizerId){

        return ResponseEntity.ok(
                financialReportService.getByOrganizer(organizerId)
        );
    }

}