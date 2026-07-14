package com.Hikerent.repository;

import com.Hikerent.entity.Mountain;
import com.Hikerent.entity.MountainStatus;
import com.Hikerent.enums.MountainStatusType;
import com.Hikerent.enums.WeatherStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MountainStatusRepository extends JpaRepository<MountainStatus, Long> {

    List<MountainStatus> findByMountain(Mountain mountain);

    List<MountainStatus> findByStatus(MountainStatusType status);

    List<MountainStatus> findByCuaca(WeatherStatus cuaca);

}