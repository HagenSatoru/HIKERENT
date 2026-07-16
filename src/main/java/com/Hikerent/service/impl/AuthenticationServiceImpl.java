package com.Hikerent.service.impl;

import com.Hikerent.dto.request.LoginRequest;
import com.Hikerent.dto.request.RegisterRequest;
import com.Hikerent.dto.response.LoginResponse;
import com.Hikerent.dto.response.UserResponse;
import com.Hikerent.entity.User;
import com.Hikerent.repository.UserRepository;
import com.Hikerent.security.JwtService;
import com.Hikerent.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email sudah digunakan");
        }

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username sudah digunakan");
        }

        User user = User.builder()
                .nama(request.getNama())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .noHp(request.getNoHp())
                .alamat(request.getAlamat())
                .foto(request.getFoto())
                .role(request.getRole())
                .aktif(true)
                .build();

        User savedUser = userRepository.save(user);

        return mapToResponse(savedUser);
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Email tidak ditemukan"));

        String token = jwtService.generateToken(user.getEmail());

        LoginResponse response = new LoginResponse();

        response.setMessage("Login berhasil");
        response.setEmail(user.getEmail());
        response.setRole(user.getRole().name());
        response.setToken(token);

        return response;
    }

    private UserResponse mapToResponse(User user) {

        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole().name());

        return response;
    }
}