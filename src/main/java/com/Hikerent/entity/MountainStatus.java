package com.Hikerent.entity;

import jakarta.persistence.*;
import lombok.*;
import com.Hikerent.enums.MountainStatusType;
import com.Hikerent.enums.WeatherStatus;
import java.time.LocalDateTime;

@Entity
@Table(name = "mountain_status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MountainStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MountainStatusType status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WeatherStatus cuaca;
    private LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "mountain_id")
    private Mountain mountain;

    @PrePersist
    public void prePersist(){
        updateAt = LocalDateTime.now();
    }

}