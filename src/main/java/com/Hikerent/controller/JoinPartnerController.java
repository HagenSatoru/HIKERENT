package com.Hikerent.controller;

import com.Hikerent.dto.request.JoinPartnerRequest;
import com.Hikerent.dto.response.JoinPartnerResponse;
import com.Hikerent.service.JoinPartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/join-partners")
@RequiredArgsConstructor
public class JoinPartnerController {

    private final JoinPartnerService joinPartnerService;

    @PostMapping
    public ResponseEntity<JoinPartnerResponse> register(
            @RequestBody JoinPartnerRequest request){

        return ResponseEntity.ok(
                joinPartnerService.register(request)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<JoinPartnerResponse> getById(
            @PathVariable Long id){

        return ResponseEntity.ok(
                joinPartnerService.getById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<JoinPartnerResponse>> getAll(){

        return ResponseEntity.ok(
                joinPartnerService.getAll()
        );
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<String> approve(
            @PathVariable Long id){

        joinPartnerService.approve(id);

        return ResponseEntity.ok("Pengajuan berhasil disetujui");
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<String> reject(
            @PathVariable Long id){

        joinPartnerService.reject(id);

        return ResponseEntity.ok("Pengajuan berhasil ditolak");
    }

}