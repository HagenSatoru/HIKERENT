package com.Hikerent.repository;

import com.Hikerent.entity.FinancialReport;
import com.Hikerent.entity.Organizer;
import com.Hikerent.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancialReportRepository extends JpaRepository<FinancialReport, Long> {

    List<FinancialReport> findBySeller(Seller seller);

    List<FinancialReport> findByOrganizer(Organizer organizer);

    List<FinancialReport> findByBulanAndTahun(Integer bulan, Integer tahun);

}