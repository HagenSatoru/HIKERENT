package com.Hikerent.dto.response;

import lombok.Data;

@Data
public class MountainResponse {

    private Long id;

    private String namaGunung;

    private String provinsi;

    private String kabupaten;

    private Integer ketinggian;

    private String deskripsi;

    private String gambar;

}