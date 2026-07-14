package com.Hikerent.repository;

import com.Hikerent.entity.Order;
import com.Hikerent.entity.Payment;
import com.Hikerent.enums.PaymentMethod;
import com.Hikerent.enums.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Payment findByOrder(Order order);

    List<Payment> findByStatus(PaymentStatus status);

    List<Payment> findByMetodePembayaran(PaymentMethod metodePembayaran);

}