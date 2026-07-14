package com.Hikerent.repository;

import com.Hikerent.entity.Mountain;
import com.Hikerent.entity.OpenTrip;
import com.Hikerent.entity.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OpenTripRepository extends JpaRepository<OpenTrip, Long> {

    List<OpenTrip> findByOrganizer(Organizer organizer);

    List<OpenTrip> findByMountain(Mountain mountain);

    List<OpenTrip> findByNamaTripContainingIgnoreCase(String namaTrip);

    List<OpenTrip> findByTanggalBerangkatAfter(LocalDate tanggal);

}