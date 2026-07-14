package com.Hikerent.controller;

import com.Hikerent.dto.request.OrderRequest;
import com.Hikerent.dto.response.OrderResponse;
import com.Hikerent.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> create(
            @RequestBody OrderRequest request) {

        return ResponseEntity.ok(
                orderService.create(request)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                orderService.getById(id)
        );
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderResponse>> getByUser(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                orderService.getByUser(userId)
        );
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        orderService.updateStatus(id, status);

        return ResponseEntity.ok(
                "Status order berhasil diperbarui"
        );
    }

}