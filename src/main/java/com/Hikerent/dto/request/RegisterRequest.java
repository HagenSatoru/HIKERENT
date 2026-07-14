package com.Hikerent.dto.request;

import com.Hikerent.enums.Role;
import lombok.Data;

@Data
public class RegisterRequest {

    private String username;

    private String email;

    private String password;

    public Role getRole() {
        return null;
    }
}