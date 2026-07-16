package com.Hikerent.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    private String message;

    private String email;

    private String role;

    private String token;

}