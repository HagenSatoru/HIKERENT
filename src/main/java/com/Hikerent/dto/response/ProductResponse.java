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

    private String namaSeller;     // Akan terisi jika produk milik seller (bisa null)

    private String namaOrganizer;  // Tambahan: Akan terisi jika produk milik organizer (bisa null)

    private String namaKategori;

}