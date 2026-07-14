package com.Hikerent.service;

import com.Hikerent.dto.request.CategoryRequest;
import com.Hikerent.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse create(CategoryRequest request);

    CategoryResponse update(Long id, CategoryRequest request);

    CategoryResponse getById(Long id);

    List<CategoryResponse> getAll();

    void delete(Long id);

}