package com.Hikerent.dto.request;

import lombok.Data;

@Data
public class RegisterRequest {

    private String nama;

    private String username;

    private String email;

    private String password;

    private String nohp;

    private String alamat;

}