package com.Hikerent.service.impl;


import com.Hikerent.dto.request.CartItemRequest;
import com.Hikerent.dto.response.CartResponse;
import com.Hikerent.entity.Cart;
import com.Hikerent.entity.CartItem;
import com.Hikerent.entity.Product;

import com.Hikerent.repository.CartItemRepository;
import com.Hikerent.repository.CartRepository;
import com.Hikerent.repository.ProductRepository;

import com.Hikerent.service.CartService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {


    private final CartRepository cartRepository;

    private final CartItemRepository cartItemRepository;

    private final ProductRepository productRepository;



    @Override
    public CartResponse getCart(Long userId) {


        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() ->
                        new RuntimeException("Cart tidak ditemukan")
                );


        return mapToResponse(cart);

    }



    @Override
    public CartResponse addItem(CartItemRequest request) {


        Cart cart = cartRepository.findById(request.getCartId())
                .orElseThrow(() ->
                        new RuntimeException("Cart tidak ditemukan")
                );



        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() ->
                        new RuntimeException("Produk tidak ditemukan")
                );



        CartItem item = CartItem.builder()
                .cart(cart)
                .product(product)
                .jumlah(request.getJumlah())
                .build();



        cartItemRepository.save(item);



        return mapToResponse(cart);

    }



    @Override
    public void removeItem(Long cartItemId) {

        cartItemRepository.deleteById(cartItemId);

    }



    private CartResponse mapToResponse(Cart cart){


        CartResponse response = new CartResponse();


        response.setId(cart.getId());

        response.setUserId(
                cart.getUser().getId()
        );


        return response;

    }


}