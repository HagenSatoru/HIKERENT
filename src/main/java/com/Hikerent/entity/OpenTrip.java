package com.Hikerent.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "open_trips")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OpenTrip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String namaTrip;

    @Column(columnDefinition = "TEXT")
    private String deskripsi;

    @Column(nullable = false)
    private BigDecimal harga;

    @Column(nullable = false)
    private Integer kuota;

    private LocalDate tanggalBerangkat;

    private LocalDate tanggalPulang;

    private String meetingPoint;

    private String gambar;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private Organizer organizer;

    @ManyToOne
    @JoinColumn(name = "mountain_id")
    private Mountain mountain;

}