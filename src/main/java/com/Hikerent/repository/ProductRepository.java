package com.Hikerent.repository;

import com.Hikerent.entity.Category;
import com.Hikerent.entity.Product;
import com.Hikerent.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findBySeller(Seller seller);

    List<Product> findByCategory(Category category);

    List<Product> findByNamaProdukContainingIgnoreCase(String namaProduk);

    List<Product> findByStokGreaterThan(Integer stok);

    List<Product> findByTersedia(Boolean tersedia);

}