package com.Hikerent.controller;

import com.Hikerent.dto.request.PaymentRequest;
import com.Hikerent.dto.response.PaymentResponse;
import com.Hikerent.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponse> create(
            @RequestBody PaymentRequest request) {

        return ResponseEntity.ok(
                paymentService.create(request)
        );
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<PaymentResponse> getByOrder(
            @PathVariable Long orderId) {

        return ResponseEntity.ok(
                paymentService.getByOrder(orderId)
        );
    }

    @PutMapping("/verify/{paymentId}")
    public ResponseEntity<String> verify(
            @PathVariable Long paymentId) {

        paymentService.verify(paymentId);

        return ResponseEntity.ok(
                "Pembayaran berhasil diverifikasi"
        );
    }

}