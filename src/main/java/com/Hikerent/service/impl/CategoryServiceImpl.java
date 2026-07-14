package com.Hikerent.service.impl;


import com.Hikerent.dto.request.CategoryRequest;
import com.Hikerent.dto.response.CategoryResponse;
import com.Hikerent.entity.Category;
import com.Hikerent.repository.CategoryRepository;
import com.Hikerent.service.CategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;



    @Override
    public CategoryResponse create(CategoryRequest request) {


        Category category = Category.builder()
                .namaKategori(request.getNamaKategori())
                .build();


        Category saved = categoryRepository.save(category);


        return mapToResponse(saved);

    }




    @Override
    public CategoryResponse update(Long id, CategoryRequest request) {


        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Category tidak ditemukan")
                );


        category.setNamaKategori(request.getNamaKategori());


        return mapToResponse(
                categoryRepository.save(category)
        );

    }





    @Override
    public CategoryResponse getById(Long id) {


        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Category tidak ditemukan")
                );


        return mapToResponse(category);

    }





    @Override
    public List<CategoryResponse> getAll() {


        return categoryRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();

    }





    @Override
    public void delete(Long id) {

        categoryRepository.deleteById(id);

    }





    private CategoryResponse mapToResponse(Category category){


        CategoryResponse response = new CategoryResponse();


        response.setId(category.getId());

        response.setNamaKategori(
                category.getNamaKategori()
        );


        return response;

    }

}