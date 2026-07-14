package com.Hikerent.dto.request;

import lombok.Data;

@Data
public class MountainRequest {

    private String namaGunung;

    private String provinsi;

    private String kabupaten;

    private Integer ketinggian;

    private String deskripsi;

    private String gambar;

}