package com.Hikerent.service;

import com.Hikerent.dto.request.NewsRequest;
import com.Hikerent.dto.response.NewsResponse;

import java.util.List;

public interface NewsService {


    NewsResponse create(NewsRequest request);


    NewsResponse update(Long id, NewsRequest request);


    NewsResponse getById(Long id);


    List<NewsResponse> getAll();


    void delete(Long id);

}