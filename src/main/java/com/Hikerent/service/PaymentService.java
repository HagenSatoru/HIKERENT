package com.Hikerent.service;

import com.Hikerent.dto.request.PaymentRequest;
import com.Hikerent.dto.response.PaymentResponse;

public interface PaymentService {

    PaymentResponse create(PaymentRequest request);

    PaymentResponse getByOrder(Long orderId);

    void verify(Long paymentId);

}