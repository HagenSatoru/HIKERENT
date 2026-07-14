package com.Hikerent.service;

import com.Hikerent.dto.request.CartItemRequest;
import com.Hikerent.dto.response.CartResponse;

public interface CartService {

    CartResponse getCart(Long userId);

    CartResponse addItem(CartItemRequest request);

    void removeItem(Long cartItemId);

}