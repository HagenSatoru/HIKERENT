package com.Hikerent.service;

import com.Hikerent.dto.request.LoginRequest;
import com.Hikerent.dto.request.RegisterRequest;
import com.Hikerent.dto.response.LoginResponse;
import com.Hikerent.dto.response.UserResponse;


public interface AuthenticationService {


    UserResponse register(RegisterRequest request);


    LoginResponse login(LoginRequest request);


}