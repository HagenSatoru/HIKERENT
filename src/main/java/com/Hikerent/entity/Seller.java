package com.Hikerent.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sellers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String namaToko;

    @Column(columnDefinition = "TEXT")
    private String deskripsi;

    @Column(columnDefinition = "TEXT")
    private String alamat;

    @Column(nullable = false, unique = true)
    private String nomorTelepon;

    @Column(nullable = false, unique = true)
    private String email;

    @Builder.Default
    @Column(nullable = false)
    private Boolean verified = false;

    private LocalDateTime createdAt;

    @JsonIgnore
    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private List<Product> products;

    @JsonIgnore
    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private List<FinancialReport> financialReports;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

}