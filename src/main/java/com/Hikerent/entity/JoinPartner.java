package com.Hikerent.entity;
import jakarta.persistence.*;
import lombok.*;
import com.Hikerent.enums.JoinPartnerStatus;
import java.time.LocalDateTime;

@Entity
@Table(name = "join_partners")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JoinPartner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String jenis;

    @Column(nullable = false)
    private String namaUsaha;

    @Column(columnDefinition = "TEXT")
    private String alamat;

    @Column(columnDefinition = "TEXT")
    private String deskripsi;

    private String nomorWhatsapp;

    private String emailUsaha;

    private String dokumen;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)

    @Builder.Default
    private JoinPartnerStatus status = JoinPartnerStatus.MENUNGGU;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

}