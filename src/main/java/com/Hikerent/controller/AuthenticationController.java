package com.Hikerent.controller;


import com.Hikerent.dto.request.LoginRequest;
import com.Hikerent.dto.request.RegisterRequest;
import com.Hikerent.dto.response.LoginResponse;
import com.Hikerent.dto.response.UserResponse;
import com.Hikerent.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {



    private final AuthenticationService authenticationService;



    // =========================
    // REGISTER
    // =========================

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(
            @RequestBody RegisterRequest request
    ){

        return ResponseEntity.ok(
                authenticationService.register(request)
        );

    }





    // =========================
    // LOGIN
    // =========================

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request
    ){

        return ResponseEntity.ok(
                authenticationService.login(request)
        );

    }


}