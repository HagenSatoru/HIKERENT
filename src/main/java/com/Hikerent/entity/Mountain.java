package com.Hikerent.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "mountains")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mountain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String namaGunung;

    @Column(nullable = false)
    private String provinsi;

    @Column(nullable = false)
    private String kabupaten;

    private Integer ketinggian;

    @Column(columnDefinition = "TEXT")
    private String deskripsi;

    private String gambar;

    @JsonIgnore
    @OneToMany(mappedBy = "mountain", cascade = CascadeType.ALL)
    private List<MountainStatus> mountainStatuses;

    @JsonIgnore
    @OneToMany(mappedBy = "mountain", cascade = CascadeType.ALL)
    private List<OpenTrip> openTrips;

}