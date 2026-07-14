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


import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {


    private final PaymentRepository paymentRepository;

    private final OrderRepository orderRepository;



    @Override
    public PaymentResponse create(PaymentRequest request) {


        Order order =
                orderRepository.findById(request.getOrderId())
                        .orElseThrow(() ->
                                new RuntimeException("Order tidak ditemukan")
                        );


        Payment payment = Payment.builder()

                .order(order)

                .nominal(request.getNominal())

                .buktiTransfer(
                        request.getBuktiTransfer()
                )

                .metodePembayaran(
                        request.getMetodePembayaran()
                )

                .status(
                        PaymentStatus.WAITING
                )

                .tanggalPembayaran(
                        LocalDateTime.now()
                )

                .build();



        return mapToResponse(
                paymentRepository.save(payment)
        );

    }





    @Override
    public PaymentResponse getById(Long id) {


        Payment payment =
                paymentRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Payment tidak ditemukan")
                        );


        return mapToResponse(payment);

    }





    @Override
    public void updateStatus(Long id, PaymentStatus status) {


        Payment payment =
                paymentRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Payment tidak ditemukan")
                        );


        payment.setStatus(status);


        paymentRepository.save(payment);

    }





    private PaymentResponse mapToResponse(Payment payment){


        PaymentResponse response =
                new PaymentResponse();


        response.setId(payment.getId());

        response.setNominal(
                payment.getNominal()
        );

        response.setStatus(
                payment.getStatus()
        );


        return response;

    }


}