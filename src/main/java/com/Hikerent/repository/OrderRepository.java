package com.Hikerent.repository;

import com.Hikerent.entity.Order;
import com.Hikerent.entity.User;
import com.Hikerent.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findByNomorOrder(String nomorOrder);

    List<Order> findByUser(User user);

    List<Order> findByStatus(OrderStatus status);

}