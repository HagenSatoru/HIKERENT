package com.Hikerent.entity;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.time.LocalDateTime;

@Entity
@Table(name = "organizers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Organizer {

    @JsonIgnore
    @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL)
    private List<FinancialReport> financialReports;

    @JsonIgnore
    @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL)
    private List<OpenTrip> openTrips;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String namaOrganizer;

    @Column(columnDefinition = "TEXT")
    private String deskripsi;

    @Column(columnDefinition = "TEXT")
    private String alamat;

    @Builder.Default
    private Boolean verified = false;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

}