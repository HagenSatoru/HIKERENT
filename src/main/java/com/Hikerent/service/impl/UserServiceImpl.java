package com.Hikerent.service.impl;


import com.Hikerent.dto.request.UserRequest;
import com.Hikerent.dto.response.UserResponse;
import com.Hikerent.entity.User;
import com.Hikerent.repository.UserRepository;
import com.Hikerent.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;



    @Override
    public UserResponse create(UserRequest request) {


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
    public UserResponse update(
            Long id,
            UserRequest request
    ) {


        User user =
                userRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "User tidak ditemukan"
                                )
                        );


        user.setUsername(
                request.getUsername()
        );


        user.setEmail(
                request.getEmail()
        );


        user.setPassword(
                request.getPassword()
        );


        user.setRole(
                request.getRole()
        );


        User updatedUser =
                userRepository.save(user);


        return mapToResponse(updatedUser);

    }





    @Override
    public UserResponse getById(Long id) {


        User user =
                userRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "User tidak ditemukan"
                                )
                        );


        return mapToResponse(user);

    }





    @Override
    public List<UserResponse> getAll() {


        return userRepository.findAll()

                .stream()

                .map(this::mapToResponse)

                .toList();

    }





    @Override
    public void delete(Long id) {


        userRepository.deleteById(id);

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