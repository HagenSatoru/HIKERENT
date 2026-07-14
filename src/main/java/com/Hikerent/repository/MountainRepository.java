package com.Hikerent.repository;

import com.Hikerent.entity.Mountain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MountainRepository extends JpaRepository<Mountain, Long> {

    List<Mountain> findByNamaGunungContainingIgnoreCase(String namaGunung);

    List<Mountain> findByProvinsiContainingIgnoreCase(String provinsi);

    List<Mountain> findByKabupatenContainingIgnoreCase(String kabupaten);

}