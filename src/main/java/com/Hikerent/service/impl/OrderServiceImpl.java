package com.Hikerent.service.impl;

import com.Hikerent.dto.request.OrderRequest;
import com.Hikerent.dto.response.OrderResponse;
import com.Hikerent.entity.*;
import com.Hikerent.enums.OrderStatus;
import com.Hikerent.repository.*;
import com.Hikerent.service.OrderService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    private final ProductRepository productRepository;



    @Override
    public OrderResponse create(OrderRequest request) {


        User user =
                userRepository.findById(request.getUserId())
                        .orElseThrow(() ->
                                new RuntimeException("User tidak ditemukan")
                        );


        Order order = Order.builder()
                .user(user)
                .nomorOrder(
                        "ORDER-" + System.currentTimeMillis()
                )
                .totalHarga(request.getTotalHarga())
                .status(OrderStatus.PENDING)
                .tanggalOrder(LocalDateTime.now())
                .build();


        Order saved =
                orderRepository.save(order);


        return mapToResponse(saved);

    }





    @Override
    public OrderResponse getById(Long id) {


        Order order =
                orderRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Order tidak ditemukan")
                        );


        return mapToResponse(order);

    }





    @Override
    public List<OrderResponse> getAll() {


        return orderRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();

    }





    @Override
    public void updateStatus(Long id, OrderStatus status) {


        Order order =
                orderRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Order tidak ditemukan")
                        );


        order.setStatus(status);


        orderRepository.save(order);

    }





    private OrderResponse mapToResponse(Order order){


        OrderResponse response =
                new OrderResponse();


        response.setId(order.getId());

        response.setNomorOrder(
                order.getNomorOrder()
        );

        response.setTotalHarga(
                order.getTotalHarga()
        );

        response.setStatus(
                order.getStatus()
        );


        return response;

    }


}