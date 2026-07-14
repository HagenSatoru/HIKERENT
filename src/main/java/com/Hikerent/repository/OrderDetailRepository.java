package com.Hikerent.repository;

import com.Hikerent.entity.OpenTrip;
import com.Hikerent.entity.Order;
import com.Hikerent.entity.OrderDetail;
import com.Hikerent.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    List<OrderDetail> findByOrder(Order order);

    List<OrderDetail> findByProduct(Product product);

    List<OrderDetail> findByOpenTrip(OpenTrip openTrip);

}