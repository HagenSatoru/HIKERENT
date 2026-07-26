package com.Hikerent.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String namaProduk;

    @Column(columnDefinition = "TEXT")
    private String deskripsi;

    @Column(nullable = false)
    private BigDecimal hargaBeli;

    @Column(nullable = false)
    private BigDecimal hargaSewa;

    @Column(nullable = false)
    private Integer stok;

    @Column(nullable = false)
    private Boolean tersedia;

    // Seller sekarang bisa null jika produk ini milik Organizer
    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = true)
    private Seller seller;

    // Relasi baru ke Organizer (bisa null jika produk milik Seller umum)
    @ManyToOne
    @JoinColumn(name = "organizer_id", nullable = true)
    private Organizer organizer;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductImage> images;

}