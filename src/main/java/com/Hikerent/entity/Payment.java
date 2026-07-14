package com.Hikerent.entity;

import jakarta.persistence.*;
import lombok.*;
import com.Hikerent.enums.PaymentMethod;
import com.Hikerent.enums.PaymentStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal nominal;

    private String buktiTransfer;

    private LocalDateTime tanggalPembayaran;

    @Enumerated(EnumType.STRING)
    private PaymentMethod metodePembayaran;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @PrePersist
    public void prePersist() {
        tanggalPembayaran = LocalDateTime.now();
    }

}