package com.Hikerent.dto.request;

import lombok.Data;

@Data
public class SellerRequest {

    private Long userId;

    private String namaToko;

    private String alamatToko;

    private String nomorTelepon;

    private String email;

}