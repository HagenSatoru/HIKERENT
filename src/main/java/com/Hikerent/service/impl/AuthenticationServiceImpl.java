package com.Hikerent.service.impl;


import com.Hikerent.dto.request.LoginRequest;
import com.Hikerent.dto.request.RegisterRequest;
import com.Hikerent.dto.response.LoginResponse;
import com.Hikerent.dto.response.UserResponse;
import com.Hikerent.entity.User;
import com.Hikerent.repository.UserRepository;
import com.Hikerent.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {


    private final UserRepository userRepository;



    @Override
    public UserResponse register(RegisterRequest request) {


        User user = User.builder()

                .username(request.getUsername())

                .email(request.getEmail())

                .password(request.getPassword())

                .role(request.getRole())

                .build();



        User savedUser =
                userRepository.save(user);



        return mapToResponse(savedUser);

    }





    @Override
    public LoginResponse login(LoginRequest request) {


        User user =
                userRepository.findByEmail(
                                request.getEmail()
                        )
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Email tidak ditemukan"
                                )
                        );



        if(!user.getPassword()
                .equals(request.getPassword())){


            throw new RuntimeException(
                    "Password salah"
            );

        }



        LoginResponse response =
                new LoginResponse();


        response.setMessage(
                "Login berhasil"
        );


        response.setEmail(
                user.getEmail()
        );


        response.setRole(
                user.getRole().toString()
        );



        return response;

    }





    private UserResponse mapToResponse(User user){


        UserResponse response =
                new UserResponse();


        response.setId(
                user.getId()
        );


        response.setUsername(
                user.getUsername()
        );


        response.setEmail(
                user.getEmail()
        );


        response.setRole(
                user.getRole().toString()
        );


        return response;

    }

}