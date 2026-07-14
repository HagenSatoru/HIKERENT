package com.Hikerent.service;

import com.Hikerent.dto.request.SellerRequest;
import com.Hikerent.dto.response.SellerResponse;

import java.util.List;

public interface SellerService {

    SellerResponse create(SellerRequest request);

    SellerResponse update(Long id, SellerRequest request);

    SellerResponse getById(Long id);

    List<SellerResponse> getAll();

    void delete(Long id);

}