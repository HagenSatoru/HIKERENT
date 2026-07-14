package com.Hikerent.repository;

import com.Hikerent.entity.Notification;
import com.Hikerent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByUser(User user);

    List<Notification> findByDibaca(Boolean dibaca);

    List<Notification> findByUserAndDibaca(User user, Boolean dibaca);

}