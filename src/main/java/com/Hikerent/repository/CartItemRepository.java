package com.Hikerent.repository;

import com.Hikerent.entity.Cart;
import com.Hikerent.entity.CartItem;
import com.Hikerent.entity.OpenTrip;
import com.Hikerent.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findByCart(Cart cart);

    List<CartItem> findByProduct(Product product);

    List<CartItem> findByOpenTrip(OpenTrip openTrip);

}