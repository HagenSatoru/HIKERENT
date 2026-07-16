package com.Hikerent.dto.request;

import com.Hikerent.enums.Role;
import lombok.Data;

@Data
public class RegisterRequest {

    private String nama;

    private String username;

    private String email;

    private String password;

    private String noHp;

    private String alamat;

    private String foto;

    private Role role;

}