package com.Hikerent.controller;

import com.Hikerent.dto.request.CartItemRequest;
import com.Hikerent.dto.response.CartResponse;
import com.Hikerent.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/{userId}")
    public ResponseEntity<CartResponse> getCart(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                cartService.getCart(userId)
        );
    }

    @PostMapping("/add")
    public ResponseEntity<CartResponse> addItem(
            @RequestBody CartItemRequest request) {

        return ResponseEntity.ok(
                cartService.addItem(request)
        );
    }

    @DeleteMapping("/item/{cartItemId}")
    public ResponseEntity<String> removeItem(
            @PathVariable Long cartItemId) {

        cartService.removeItem(cartItemId);

        return ResponseEntity.ok(
                "Item berhasil dihapus dari keranjang"
        );
    }

}