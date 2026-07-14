package com.Hikerent.service.impl;

import com.Hikerent.dto.request.PaymentRequest;
import com.Hikerent.dto.response.PaymentResponse;
import com.Hikerent.entity.Order;
import com.Hikerent.entity.Payment;
import com.Hikerent.enums.PaymentStatus;
import com.Hikerent.repository.OrderRepository;
import com.Hikerent.repository.PaymentRepository;
import com.Hikerent.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    @Override
    public PaymentResponse create(PaymentRequest request) {

        Order order = orderRepository.findById(request.getOrderId())
                .orElseThrow(() ->
                        new RuntimeException("Order tidak ditemukan"));

        Payment payment = Payment.builder()
                .order(order)
                .nominal(request.getNominal())
                .buktiTransfer(request.getBuktiTransfer())
                .metodePembayaran(request.getMetodePembayaran())
                .status(PaymentStatus.MENUNGGU_VERIFIKASI)
                .build();

        Payment saved = paymentRepository.save(payment);

        return mapToResponse(saved);
    }

    @Override
    public PaymentResponse getByOrder(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new RuntimeException("Order tidak ditemukan"));

        Payment payment = paymentRepository.findByOrder(order);

        if (payment == null) {
            throw new RuntimeException("Payment tidak ditemukan");
        }

        return mapToResponse(payment);
    }

    @Override
    public void verify(Long paymentId) {

        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() ->
                        new RuntimeException("Payment tidak ditemukan"));

        payment.setStatus(PaymentStatus.BERHASIL);

        paymentRepository.save(payment);
    }

    private PaymentResponse mapToResponse(Payment payment) {

        PaymentResponse response = new PaymentResponse();

        response.setId(payment.getId());
        response.setNominal(payment.getNominal());
        response.setBuktiTransfer(payment.getBuktiTransfer());

        if (payment.getMetodePembayaran() != null) {
            response.setMetodePembayaran(payment.getMetodePembayaran().name());
        }

        if (payment.getStatus() != null) {
            response.setStatus(payment.getStatus().name());
        }

        response.setTanggalPembayaran(payment.getTanggalPembayaran());

        return response;
    }
}