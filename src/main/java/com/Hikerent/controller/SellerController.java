package com.Hikerent.controller;

import com.Hikerent.dto.request.SellerRequest;
import com.Hikerent.dto.response.SellerResponse;
import com.Hikerent.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sellers")
@RequiredArgsConstructor
public class SellerController {

    private final SellerService sellerService;

    @PostMapping
    public ResponseEntity<SellerResponse> create(
            @RequestBody SellerRequest request) {

        return ResponseEntity.ok(
                sellerService.create(request)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<SellerResponse> update(
            @PathVariable Long id,
            @RequestBody SellerRequest request) {

        return ResponseEntity.ok(
                sellerService.update(id, request)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<SellerResponse> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                sellerService.getById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<SellerResponse>> getAll() {

        return ResponseEntity.ok(
                sellerService.getAll()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {

        sellerService.delete(id);

        return ResponseEntity.ok("Seller berhasil dihapus");
    }

}