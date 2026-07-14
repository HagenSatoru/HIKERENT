package com.Hikerent.repository;

import com.Hikerent.entity.Organizer;
import com.Hikerent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Long> {

    Optional<Organizer> findByUser(User user);

}