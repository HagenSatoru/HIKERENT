package com.Hikerent.service.impl;

import com.Hikerent.dto.request.OrderRequest;
import com.Hikerent.dto.response.OrderResponse;
import com.Hikerent.entity.Cart;
import com.Hikerent.entity.Order;
import com.Hikerent.entity.User;
import com.Hikerent.enums.OrderStatus;
import com.Hikerent.repository.CartRepository;
import com.Hikerent.repository.OrderRepository;
import com.Hikerent.repository.UserRepository;
import com.Hikerent.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;

    @Override
    public OrderResponse create(OrderRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User tidak ditemukan"));

        Cart cart = cartRepository.findById(request.getCartId())
                .orElseThrow(() ->
                        new RuntimeException("Cart tidak ditemukan"));

        // sementara total harga dibuat 0,
        // nanti akan dihitung dari CartItem
        BigDecimal totalHarga = BigDecimal.ZERO;

        Order order = Order.builder()
                .user(user)
                .nomorOrder("ORDER-" + System.currentTimeMillis())
                .totalHarga(totalHarga)
                .status(OrderStatus.MENUNGGU_PEMBAYARAN)
                .tanggalOrder(LocalDateTime.now())
                .build();

        return mapToResponse(orderRepository.save(order));
    }

    @Override
    public OrderResponse getById(Long id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order tidak ditemukan"));

        return mapToResponse(order);
    }

    @Override
    public List<OrderResponse> getByUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User tidak ditemukan"));

        return orderRepository.findByUser(user)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public void updateStatus(Long id, String status) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order tidak ditemukan"));

        order.setStatus(OrderStatus.valueOf(status.toUpperCase()));

        orderRepository.save(order);
    }

    private OrderResponse mapToResponse(Order order) {

        OrderResponse response = new OrderResponse();

        response.setId(order.getId());
        response.setNomorOrder(order.getNomorOrder());
        response.setTotalHarga(order.getTotalHarga());
        response.setStatus(order.getStatus().name());
        response.setTanggalOrder(order.getTanggalOrder());

        return response;
    }
}