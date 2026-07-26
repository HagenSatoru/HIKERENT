package com.Hikerent.dto.request;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductRequest {

    private String namaProduk;

    private String deskripsi;

    private BigDecimal hargaBeli;

    private BigDecimal hargaSewa;

    private Integer stok;

    private Boolean tersedia;

    private Long sellerId;     // Opsional (bisa null jika milik organizer)

    private Long organizerId;  // Tambahan: Opsional (bisa null jika milik seller)

    private Long categoryId;

}