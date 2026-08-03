package com.Hikerent.controller;

import com.Hikerent.dto.request.ProductRequest;
import com.Hikerent.dto.response.ProductResponse;
import com.Hikerent.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> create(
            @RequestBody ProductRequest request) {

        return ResponseEntity.ok(
                productService.create(request)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(
            @PathVariable Long id,
            @RequestBody ProductRequest request) {

        return ResponseEntity.ok(
                productService.update(id, request)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                productService.getById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAll() {

        return ResponseEntity.ok(
                productService.getAll()
        );
    }

    // Endpoint baru: Mendapatkan produk/alat berdasarkan Organizer
    @GetMapping("/organizer/{organizerId}")
    public ResponseEntity<List<ProductResponse>> getByOrganizerId(
            @PathVariable Long organizerId) {

        return ResponseEntity.ok(
                productService.getByOrganizerId(organizerId)
        );
    }
    // Tambahkan endpoint ini di ProductController.java
    @GetMapping("/seller")
    public ResponseEntity<List<ProductResponse>> getByCurrentSeller(java.security.Principal principal) {
        // Ambil email/username dari token yang sedang login (principal.getName())
        // Lalu cari produk berdasarkan seller tersebut melalui productService
        return ResponseEntity.ok(productService.getBySellerEmail(principal.getName()));
    }
    @GetMapping("/search")
    public ResponseEntity<List<ProductResponse>> search(
            @RequestParam String keyword) {

        return ResponseEntity.ok(
                productService.search(keyword)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {

        productService.delete(id);

        return ResponseEntity.ok("Produk berhasil dihapus");
    }

}