package com.Hikerent.service;

import com.Hikerent.dto.request.ProductRequest;
import com.Hikerent.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse create(ProductRequest request);

    ProductResponse update(Long id, ProductRequest request);

    ProductResponse getById(Long id);

    List<ProductResponse> getAll();

    List<ProductResponse> getByOrganizerId(Long organizerId);
    List<ProductResponse> getBySellerEmail(String email);

    List<ProductResponse> search(String keyword);

    void delete(Long id);

}