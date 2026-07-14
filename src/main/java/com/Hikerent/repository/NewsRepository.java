package com.Hikerent.repository;

import com.Hikerent.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

    List<News> findByJudulContainingIgnoreCase(String judul);

    List<News> findAllByOrderByCreatedAtDesc();

}