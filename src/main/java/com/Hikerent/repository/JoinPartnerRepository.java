package com.Hikerent.repository;

import com.Hikerent.entity.JoinPartner;
import com.Hikerent.entity.User;
import com.Hikerent.enums.JoinPartnerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JoinPartnerRepository extends JpaRepository<JoinPartner, Long> {

    List<JoinPartner> findByStatus(JoinPartnerStatus status);

    List<JoinPartner> findByUser(User user);

}