package com.Hikerent.service;

import com.Hikerent.dto.request.UserRequest;
import com.Hikerent.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse create(UserRequest request);

    UserResponse update(Long id, UserRequest request);

    UserResponse getById(Long id);

    UserResponse getByEmail(String email);

    List<UserResponse> getAll();

    void delete(Long id);
}