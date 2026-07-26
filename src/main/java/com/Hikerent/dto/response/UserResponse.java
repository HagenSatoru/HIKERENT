package com.Hikerent.dto.response;

import com.Hikerent.enums.Role;
import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String nama;
    private String username;
    private String email;
    private String noHp;
    private String alamat;
    private String foto;
    private Role role;

}