package com.Hikerent.service;

import com.Hikerent.dto.request.OrderRequest;
import com.Hikerent.dto.response.OrderResponse;

import java.util.List;

public interface OrderService {

    OrderResponse create(OrderRequest request);

    OrderResponse getById(Long id);

    List<OrderResponse> getByUser(Long userId);

    void updateStatus(Long id, String status);

}