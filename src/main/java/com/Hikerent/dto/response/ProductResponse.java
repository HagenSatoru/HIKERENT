package com.Hikerent.dto.response;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductResponse {

    private Long id;

    private String namaProduk;

    private String deskripsi;

    private BigDecimal hargaBeli;

    private BigDecimal hargaSewa;

    private Integer stok;

    private Boolean tersedia;

    private String namaSeller;

    private String namaKategori;

}